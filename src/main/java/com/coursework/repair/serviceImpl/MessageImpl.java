package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.*;
import com.coursework.repair.replies.DialogReply;
import com.coursework.repair.replies.MechanicRequestReply;
import com.coursework.repair.replies.MessageReply;
import com.coursework.repair.replies.UserRequestReply;
import com.coursework.repair.repository.*;
import com.coursework.repair.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageImpl implements MessageService {

    private final MechanicRepository mechanicRepository ;
    private final ExactRequestRepository exactRequestRepository;
    private final RequestRepository requestRepository;
    private final MessageRepository messageRepository;
    private final DialogRepository dialogRepository;
    private final CarModificationRepository carModificationRepository;

    @Autowired
    public MessageImpl(MechanicRepository mechanicRepository, ExactRequestRepository exactRequestRepository, RequestRepository requestRepository, MessageRepository messageRepository, DialogRepository dialogRepository, CarModificationRepository carModificationRepository) {
        this.mechanicRepository = mechanicRepository;
        this.exactRequestRepository = exactRequestRepository;
        this.requestRepository = requestRepository;
        this.messageRepository = messageRepository;
        this.dialogRepository = dialogRepository;
        this.carModificationRepository = carModificationRepository;
    }

    @Transactional
    @Override
    public String messageForService(long vin, ServiceEntity serviceEntity, String content) {

        exactRequestRepository.save(
                saveRequest("Request for service: " + content,
                        mechanicRepository.findByServiceByServiceIdAndAdmin(serviceEntity, true).getId(),
                        vin
                )
        );

        return "Successful";
    }

    @Override
    public String messageForMechanic(long vin, MechanicEntity mechanicEntity, String content) {

        exactRequestRepository.save(
                saveRequest(content,
                        mechanicEntity.getId(),
                        vin)
        );

        return "Successful";
    }

    @Transactional
    @Override
    public String request(CarEntity car, String content) {
        RequestEntity request = new RequestEntity();
        request.setCarId(car.getVin());
        request.setContent(content);

        requestRepository.save(request);

        return "Successful";
    }

    @Transactional
    @Override
    public String guestRequest(String modification, String content) {
        RequestEntity request = new RequestEntity();
        request.setContent("Request from guest: " + content);

        // we use car (which has such modification
        CarEntity testCar = (CarEntity) carModificationRepository.findByName(modification).getCarsById().toArray()[0];
        System.out.println("we use car with vin = " + testCar.getVin());
        request.setCarId(testCar.getVin());

        requestRepository.save(request);

        return "Successful";
    }

    @Override
    public List<MechanicRequestReply> getGeneralRequests(MechanicEntity mechanic) {
        List<MechanicRequestReply> reply = new ArrayList<>();

        mechanic.getMechanicModificationsById().forEach(mech_modification->{
            mech_modification.getCarModificationByModificationId().getCarsById().forEach(car->{
                car.getRequestsByVin().forEach(request->{

                    MechanicRequestReply next = new MechanicRequestReply();

                    if (request.getContent().contains("Request from guest: ")) next.setSender("Гость ");
                    else  next.setSender(
                            car.getManByDriverId().getName() + " " +
                                    car.getManByDriverId().getSurname()
                    );
                    next.setContent(request.getContent());
                    next.setRequestID(request.getId());
                    next.setModification(
                            car.getCarModificationByModificationId().getCarModelByModel().getCarMakeByMakeId().getName() + " " +
                            car.getCarModificationByModificationId().getCarModelByModel().getName() + " " +
                            car.getCarModificationByModificationId().getName()
//                            mech_modification.getCarModificationByModificationId().getName()
                    );

                    reply.add(next);
                });
            });
        });

        return reply;
    }

    @Override
    public List<MechanicRequestReply> getPrivateRequests(MechanicEntity mechanic) {
        List<MechanicRequestReply> reply = new ArrayList<>();

        mechanic.getExactRequestsById().forEach(request->{
            MechanicRequestReply next = new MechanicRequestReply();

            next.setSender(
                    request.getCarByCarId().getManByDriverId().getName() + " " +
                    request.getCarByCarId().getManByDriverId().getSurname()
            );
            next.setContent(request.getContent());
            next.setRequestID(request.getId());
            next.setModification(
                    request.getCarByCarId().getCarModificationByModificationId().getCarModelByModel().getCarMakeByMakeId().getName() + " " +
                    request.getCarByCarId().getCarModificationByModificationId().getCarModelByModel().getName() + " " +
                    request.getCarByCarId().getCarModificationByModificationId().getName()
            );

            reply.add(next);
        });

        return reply;
    }

    @Override
    public List<DialogReply> readMechanicDialogs(MechanicEntity mechanic) {
        List<DialogReply> dialogs = new ArrayList<>();
        System.out.println("Mechanic - " + mechanic.getManByManId().getName() + " reads dialogs ");

        mechanic.getDialogsById().forEach(dialog->{
            DialogReply next = new DialogReply();

            System.out.println("    * next dialog's topic: "+ dialog.getTopic());
            next.setDialogId(dialog.getId());
            next.setTopic(dialog.getTopic());
            next.setInterlocutor(dialog.getManByDriverId().getName()+" "+ dialog.getManByDriverId().getSurname());
            next.setLastMessage(getLastMessageFromDialog(dialog));
            next.setNew(checkNewMessages(
                    messageRepository.findAllByDialogByDialogIdAndMechread(dialog, false)
            )); // true - new ; false - only old messages

            dialogs.add(next );
        });
        return dialogs;
    }

    @Override
    public List<DialogReply> readUserDialogs(ManEntity man) {
        List<DialogReply> dialogs = new ArrayList<>();
        DialogReply dr = new DialogReply();
        man.getDialogsById().forEach(dialog-> {
            dr.setDialogId(dialog.getId());
            dr.setTopic(dialog.getTopic());
            dr.setLastMessage(getLastMessageFromDialog(dialog));
            dr.setInterlocutor(dialog.getMechanicByMechanicId().getManByManId().getName() + " "
                    + dialog.getMechanicByMechanicId().getManByManId().getSurname());
            dr.setNew(checkNewMessages(
                    messageRepository.findAllByDialogByDialogIdAndUserread(dialog, false)
            ));
            dialogs.add(dr);
        });
        return dialogs;
    }

    @Transactional
    @Override
    public List<MessageReply.Message> readUserMessages(long dialogId) {
        List<MessageReply.Message> replyMessages = new ArrayList<>();
        /*
        todo: if we sent too more messages, our front can fall down :( , maybe it's worth to sent only part ?
         */
        // get all messages in dialog
        List<MessageEntity> messages = (List<MessageEntity>) dialogRepository.findById(dialogId).getMessagesById();
        messages.forEach(m->{
            MessageReply.Message message = new MessageReply.Message();
            message.setContent(m.getContent());
            message.setDate(m.getDate());
            message.setInterlocutor(m.getDialogByDialogId().getMechanicByMechanicId().getManByManId().getName()+" "
                    +m.getDialogByDialogId().getMechanicByMechanicId().getManByManId().getSurname());
            replyMessages.add(message);
            m.setUserread(true);

            messageRepository.save(m); // save changes

        });
        return replyMessages;
    }

    @Transactional
    @Override
    public List<MessageReply.Message> readMechanicMessages(long dialogId) {
        List<MessageReply.Message> reply = new ArrayList<>();

        // get all messages in dialog
        List<MessageEntity> messages = (List<MessageEntity>) dialogRepository.findById(dialogId).getMessagesById();
        messages.forEach(m->{
            MessageReply.Message message = new MessageReply.Message();
            message.setContent(m.getContent());
            message.setDate(m.getDate());
            message.setInterlocutor(m.getManBySenderId().getName()+" "+m.getManBySenderId().getSurname());
            reply.add(message);
            m.setMechread(true);
            messageRepository.save(m); // save changes
        });
        return reply;
    }

    @Transactional
    @Override
    public String writeMessage(ManEntity man, long dialogId,String content) {
        MessageEntity newMessage = new MessageEntity();

        newMessage.setMechread(false);
        newMessage.setUserread(true);

        newMessage.setContent(content);
        newMessage.setDialogId(dialogId);
        newMessage.setSenderId(man.getId());
        newMessage.setDate(new Timestamp(System.currentTimeMillis()));

        messageRepository.save(newMessage);

        return "Successful";
    }

    @Transactional
    @Override
    public String writeMessage(MechanicEntity mechanic, long dialogId, String content) {
        MessageEntity newMessage = new MessageEntity();

        newMessage.setMechread(true);
        newMessage.setUserread(false);

        newMessage.setContent(content);
        newMessage.setDialogId(dialogId);
        newMessage.setSenderId(mechanic.getManByManId().getId());
        newMessage.setDate(new Timestamp(System.currentTimeMillis()));

        messageRepository.save(newMessage);

        return "Successful";
    }

    // todo: problem with deleting general requests :(
    // PROBLEM! i don't know how to delete this request. There are lots of mechanic, who get the request and every have a decision
    // possible decision : create new entity - MechanicRequest and save general request there :(
    @Transactional
    @Override
    public String decisionRequest(boolean decision, RequestEntity request, MechanicEntity mechanic) {// принять/отклонить заявку for general request
        if (decision) {

            DialogEntity newDialog = new DialogEntity();
            newDialog.setMechanicId(mechanic.getId());
            newDialog.setTopic(getDialogTopic(request.getCarByCarId()));
            newDialog.setDriverId(request.getCarByCarId().getDriverId());

            newDialog = dialogRepository.save(newDialog);

            MessageEntity newMessage = new MessageEntity();
            newMessage.setUserread(false);
            newMessage.setMechread(false);
            newMessage.setContent(request.getContent());
            newMessage.setSenderId(request.getCarByCarId().getDriverId());
            newMessage.setDate(new Timestamp(System.currentTimeMillis()));
            newMessage.setDialogId(newDialog.getId());

            messageRepository.save(newMessage);
        }
        // here will be smth , but no now
//        else requestRepository.delete(request);

        return "Successful";
    }

    @Transactional
    @Override
    public String decisionExactRequest(boolean decision, ExactRequestEntity request) {
        if (decision){
            DialogEntity newDialog = new DialogEntity();
            newDialog.setMechanicId(request.getMechanicId());
            newDialog.setTopic(getDialogTopic(request.getCarByCarId()));
            newDialog.setDriverId(request.getCarByCarId().getDriverId());

            newDialog = dialogRepository.save(newDialog);

            MessageEntity newMessage = new MessageEntity();
            newMessage.setUserread(false);
            newMessage.setMechread(false);
            newMessage.setContent(request.getContent());
            newMessage.setSenderId(request.getCarByCarId().getDriverId());
            newMessage.setDate(new Timestamp(System.currentTimeMillis()));
            newMessage.setDialogId(newDialog.getId());

            messageRepository.save(newMessage);
        }
        exactRequestRepository.delete(request);
        return "Successful";
    }

    @Override
    public List<UserRequestReply> getUserRequests(ManEntity man) {
        List<UserRequestReply> reply = new ArrayList<>();

        // at first, we find all exact requests
        man.getCarsById().forEach(car-> { // we get all cars of user
            // we get all exact request by current car
            exactRequestRepository.findAllByCarByCarId(car).forEach(request -> {
                UserRequestReply exactRequest = new UserRequestReply();
                exactRequest.setStatus("exact request");
                exactRequest.setContent(request.getContent());
                exactRequest.setMechanicName(
                        request.getMechanicByMechanicId().getManByManId().getName() + " " +
                        request.getMechanicByMechanicId().getManByManId().getPatronymic() + " " +
                        request.getMechanicByMechanicId().getManByManId().getSurname()
                );
                reply.add(exactRequest);
            });
            // we get all general request by current car
            requestRepository.findAllByCarByCarId(car).forEach(request ->{
                UserRequestReply generalRequest = new UserRequestReply();
                generalRequest.setStatus("general request");
                generalRequest.setContent(request.getContent());
                generalRequest.setMechanicName("Some mechanics will get this request.");

                reply.add(generalRequest);
            });
        });

        return reply;
    }


    // return 1 if there are some new messages in dialog , 0 - nothing new
    private static boolean checkNewMessages(List<MessageEntity> newMessages){
        return newMessages.size() != 0 ;
    }

    private static String getLastMessageFromDialog(DialogEntity dialogEntity){
        List<MessageEntity> messages = (List<MessageEntity>)dialogEntity.getMessagesById();

        int mes_number = messages.toArray().length;
        System.out.println("     - > Number of messages : " + messages.size());
        return ((MessageEntity)messages.toArray()[mes_number-1]).getContent();
        // if (messages.size() == 1) return
/*
        return messages.get(messages.size()).getContent();
*/
        //return "test of last message ";
    }

    private static String getDialogTopic(CarEntity car){
        return "Диалог по машине - " + car.getVin() + ". Модификация - " + car.getCarModificationByModificationId().getName();
    }

    private static ExactRequestEntity saveRequest(String content,long mechanicId, long vin){
        ExactRequestEntity request = new ExactRequestEntity();

        request.setContent(content);
        request.setMechanicId(mechanicId);
        request.setCarId(vin);

        return request;
    }
}