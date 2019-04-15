package com.coursework.repair.controller;

import com.coursework.repair.repository.CarRepository;
import com.coursework.repair.repository.ManRepository;
import com.coursework.repair.repository.MechanicRepository;
import com.coursework.repair.repository.ServiceRepository;
import com.coursework.repair.serviceImpl.MessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/*
    Register new requests :
    - to service (only authorized user ,
    - to mechanic (only authorized user)
    - general request as authorized user, or as guest
    ! be careful: as guest you need sent name of modification and write a phone in context
*/
@RestController
@RequestMapping("/message")
public class MessageController {

    private final ServiceRepository serviceRepository;
    private final MessageImpl message;
    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;
    private final ManRepository manRepository;

    @Autowired
    public MessageController(ServiceRepository serviceRepository, MessageImpl message, MechanicRepository mechanicRepository, CarRepository carRepository, ManRepository manRepository) {
        this.serviceRepository = serviceRepository;
        this.message = message;
        this.mechanicRepository = mechanicRepository;
        this.carRepository = carRepository;
        this.manRepository = manRepository;
    }

    @Secured("ROLE_DRIVER")
    @PostMapping("/forService")
    public String sentToService(@Param("serviceName")String serviceName,
                                @Param("content")String content,
                                @Param("vin") long vin,
                                @AuthenticationPrincipal Principal user){
        // check, that current user is owner of car with current vin ;
        if (! carRepository.findByVin(vin)
                .getManByDriverId().getMail()
                .equals(user.getName())
            ) return "Error: " +
                "It's not you car's VIN. " +
                "Please, check it and try again." ;
        else return message.messageForService(
                    vin,
                    serviceRepository.findByName(serviceName),
                    content);
    }


    @Secured("ROLE_DRIVER")
    @PostMapping("/forMechanic")
    public String sentToMechanic(@AuthenticationPrincipal Principal user,
                               @Param("vin") long vin,
                               @Param("mechanicId")long mechanicId,
                               @Param("content") String content){
        // user is a sender of a message !!!
        if ( !(
                carRepository.findByVin(vin).getManByDriverId().getMail().equals(user.getName())
        ) )return "Error: it's not your car. Please, be careful with vin. ";
        else {
            return message.messageForMechanic(
                    vin,
                    mechanicRepository.findById(mechanicId),
//                    mechanicRepository.findByManByManId(
//                            manRepository.findByMail(user.getName())
//                    ),
                    content);
        }
    }


    @Secured("ROLE_DRIVER")
    @PostMapping("/request")
    public String sentGeneralRequest(@Param("vin")long vin,
                                     @Param("content") String content,
                                     @AuthenticationPrincipal Principal user){
        if (! carRepository.findByVin(vin)
                .getManByDriverId().getMail()
                .equals(user.getName())
                ) return "Error: " +
                "It's not you car's VIN. " +
                "Please, check it and try again." ;
        return message.request(carRepository.findByVin(vin), content);
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/guestRequest")
    public String guestSentGeneralRequest(@Param("modification")String modification,
                                          @Param("content")String content){
        return message.guestRequest(modification, content) ;
    }



//    @RequestMapping("/readUserDialogs")
//    public List<DialogReply> getUserDialogs(@Param("userId")long userId){
//        return message.readUserDialogs(manRepository.findById(userId));
//    }
//
//
//    @RequestMapping("/readUserMessages")
//    public List<MessageReply> getUserMessages(@Param("dialogId")long dialogId){
//        return message.readUserMessages(dialogId);
//    }
//
//    @RequestMapping("/writeMessage")
//    public String writeUserMessage(@Param("manId")long manId,
//                                   @Param("dialogId")long dialogId,
//                                   @Param("content")String content){
//        return message.writeMessage(manRepository.findById(manId),dialogId,content);
//    }

}
