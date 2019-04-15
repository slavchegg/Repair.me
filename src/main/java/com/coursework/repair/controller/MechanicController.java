package com.coursework.repair.controller;

import com.coursework.repair.entity.ExactRequestEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.RequestEntity;
import com.coursework.repair.replies.DialogReply;
import com.coursework.repair.replies.MechanicReply;
import com.coursework.repair.replies.MechanicRequestReply;
import com.coursework.repair.replies.MessageReply;
import com.coursework.repair.repository.*;
import com.coursework.repair.serviceImpl.MessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/mechanic")
public class MechanicController {

    private final MechanicRepository mechanicRepository;
    private final MessageImpl message;
    private final RequestRepository requestRepository;
    private final ExactRequestRepository exactRequestRepository;
    private final ManRepository manRepository;
    private final DialogRepository dialogRepository;


    @Autowired
    public MechanicController(MechanicRepository mechanicRepository, MessageImpl message, RequestRepository requestRepository, ExactRequestRepository exactRequestRepository, ManRepository manRepository, DialogRepository dialogRepository) {
        this.mechanicRepository = mechanicRepository;
        this.message = message;
        this.requestRepository = requestRepository;
        this.exactRequestRepository = exactRequestRepository;
        this.manRepository = manRepository;
        this.dialogRepository = dialogRepository;
    }

    // get information about mechanic. all user can do it
    // user know mechanic ID ( he gets it with service reply: /service/getOne
    // todo: i add new field in ServiceReply.Mans (it is id)
    @GetMapping("/getOne")
    public MechanicReply getMechanicById(@Param("id")long id){
        MechanicReply mechanic = new MechanicReply();
        MechanicEntity m = mechanicRepository.findById(id);

        mechanic.setPost(m.getPost());
        mechanic.setAbout(m.getAbout());

        boolean is_admin = m.getAdmin();

        mechanic.setAdmin(is_admin);
        if (is_admin) mechanic.setServiceName(m.getServiceByServiceId().getName());
        else mechanic.setServiceName("no service");

        mechanic.setName(m.getManByManId().getName()+" "+m.getManByManId().getSurname());
        mechanic.setPhotoHref(m.getManByManId().getPhotoByPhotoId().getPhotoHref());

        List<String> makes = new ArrayList<>();
        m.getMechanicModificationsById().forEach(modif ->{
                    String newMake = modif.getCarModificationByModificationId().getCarModelByModel().getCarMakeByMakeId().getName();
                    if (! makes.contains(newMake)) makes.add(newMake);
                }
        );

        mechanic.setMakes(makes);

        return mechanic;
    }

    @Secured("ROLE_MECHANIC")
    @GetMapping("/readGeneralRequests")
    public List<MechanicRequestReply> getGeneralRequests(@AuthenticationPrincipal Principal user){
        return message.getGeneralRequests(
                mechanicRepository.findByManByManId(
                        manRepository.findByMail(user.getName())
                )
        );
    }

    @Secured("ROLE_MECHANIC")
    @GetMapping("/readPrivateRequests")
    public List<MechanicRequestReply> getPrivateRequests(@AuthenticationPrincipal Principal user){
        return message.getPrivateRequests(
                mechanicRepository.findByManByManId(
                        manRepository.findByMail(user.getName())
                )
        );
    }

    @Secured("ROLE_MECHANIC")
    @GetMapping("/readDialogs")
    public List<DialogReply> getMechanicDialogs(@AuthenticationPrincipal Principal user){
        return message.readMechanicDialogs(
                mechanicRepository.findByManByManId(
                        manRepository.findByMail(user.getName())
                )
        );
    }

    @Secured("ROLE_MECHANIC")
    @GetMapping("/readMessages")
    public MessageReply getMechanicMessages(@AuthenticationPrincipal Principal user,
                                                  @Param("dialogId")long dialogId){
        MessageReply reply = new MessageReply();

        MechanicEntity mechanic = mechanicRepository.findByManByManId(
                manRepository.findByMail(user.getName())
        );
        if (! (dialogRepository.findById(dialogId).getMechanicId() ==  mechanic.getId())){
            reply.setContext("Error: \n It's not your dialog. You can read it");
        } else{
            reply.setContext("Successful");
            reply.setMessages(
                    message.readMechanicMessages(dialogId)
            );
        }
        return reply;

    }

    @Secured("ROLE_MECHANIC")
    @PostMapping("/writeMessage")
    public String writeMechanicMessage(@AuthenticationPrincipal Principal user,
                                       @Param("dialogId")long dialogId,
                                       @Param("content")String content){
        MechanicEntity mechanic = mechanicRepository.findByManByManId(
                manRepository.findByMail(user.getName())
        );
        if ( ! (dialogRepository.findById(dialogId).getMechanicId() == mechanic.getId() ) ) {
            return "Error: \n It's not your dialog. You can't write new message";
        }else return message
                .writeMessage(mechanic,dialogId,content);
    }


    @Secured("ROLE_MECHANIC")
    @GetMapping("/acceptRequest")
    public String acceptRequest(@Param("decision")boolean decision,
                                @AuthenticationPrincipal Principal user,
                                @Param("requestId")long requestId){
        // i am sure that it's correct requestID (because it's too difficult to check it...
        // so i can get it easy if needed, i have big method for it
        return message.decisionRequest(
                decision,
                requestRepository.findById(requestId),
                mechanicRepository.findByManByManId(
                        manRepository.findByMail(user.getName())
                ));
    }

    @Secured("ROLE_MECHANIC")
    @GetMapping("/acceptExactRequest")
    public String acceptExactRequest(@AuthenticationPrincipal Principal user ,
                                     @Param("decision")boolean decision,
                                     @Param("requestId")long requestId){
        MechanicEntity mechanic = mechanicRepository.findByManByManId(
                manRepository.findByMail(user.getName())
        );
        ExactRequestEntity request = exactRequestRepository.findById(requestId);
        if ( !(request.getMechanicByMechanicId().getId() == mechanic.getId()) ){
            return "Error: \n It's not you dialog. You can't accept it, unfortunately(( ";
        }else return message.decisionExactRequest(decision,request);
    }

}