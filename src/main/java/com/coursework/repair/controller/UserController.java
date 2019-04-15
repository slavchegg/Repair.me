package com.coursework.repair.controller;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.replies.CarReply;
import com.coursework.repair.replies.DialogReply;
import com.coursework.repair.replies.MessageReply;
import com.coursework.repair.replies.UserRequestReply;
import com.coursework.repair.repository.DialogRepository;
import com.coursework.repair.repository.ManRepository;
import com.coursework.repair.serviceImpl.MakesImpl;
import com.coursework.repair.serviceImpl.MessageImpl;
import com.coursework.repair.serviceImpl.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/*
    Working with current user ( as driver )
    -> read all dialogs
    -> read all messages in dialog
        ( ! be careful, i check, that user is owner of dialog,
        so user dialog and mechanic are different, user other controller for mechanic )
    -> write new message in dialog ( i also check dialog ID )
    -> get all request
    todo: i don't know , how say about deleted request
    -> get all cars (of current user, of course)

*/

@RestController
@RequestMapping("/user")
public class UserController {

    private final MessageImpl message;
    private final ManRepository manRepository;
    private final DialogRepository dialogRepository;
    private final MakesImpl makes;
    private final RegistrationServiceImpl registered;

    @Autowired
    public UserController(MessageImpl message, ManRepository manRepository, DialogRepository dialogRepository, MakesImpl makes, RegistrationServiceImpl registered) {
        this.message = message;
        this.manRepository = manRepository;
        this.dialogRepository = dialogRepository;
        this.makes = makes;
        this.registered = registered;
    }

    @Secured("ROLE_DRIVER")
    @GetMapping("/readUserDialogs")
    public List<DialogReply> getUserDialogs(@AuthenticationPrincipal Principal user){
        ManEntity man = manRepository.findByMail(user.getName());
        return message.readUserDialogs(manRepository.findById(man.getId()));
    }

    @Secured("ROLE_DRIVER")
    @GetMapping("/readUserMessages")
    public MessageReply getUserMessages(@AuthenticationPrincipal Principal user,
                                              @Param("dialogId")long dialogId){
        ManEntity man = manRepository.findByMail(user.getName());
        MessageReply reply = new MessageReply();
        if (
               ! (dialogRepository.findById(dialogId).getManByDriverId().getId() == man.getId())
                ){

            reply.setContext("Error: \n It's not you dialog.");
            return reply;
        }else{
            reply.setContext("Successful checking dialog ID.");
            reply.setMessages(
                    message.readUserMessages(dialogId)
            );
            return reply;
        }
    }

    @Secured("ROLE_DRIVER")
    @PostMapping("/writeMessage")
    public String writeUserMessage(@AuthenticationPrincipal Principal user,
                                   @Param("dialogId")long dialogId,
                                   @Param("content")String content){
        ManEntity man = manRepository.findByMail(user.getName());
        if (
                ! (dialogRepository.findById(dialogId).getManByDriverId().getId() == man.getId())
                ) return "Error: \n It's not your dialog. You can't write new message. ";
        else return message.writeMessage(
                man,dialogId,content
        );
    }

    @Secured("ROLE_DRIVER")
    @GetMapping("/getRequests")
    public List<UserRequestReply> getRequests(@AuthenticationPrincipal Principal user){
        return message.getUserRequests(
                        manRepository.findByMail(user.getName())
        );
    }

    @Secured("ROLE_DRIVER")
    @GetMapping("/getCars")
    public List<CarReply> getCars(@AuthenticationPrincipal Principal user){
        return makes.getAllUserCars(
                manRepository.findByMail(user.getName())
        );
    }


    // be careful! it's other methods to change mail or password !!! also you can't change photo (now)
    @Secured("ROLE_DRIVER")
    @PostMapping("/changeUserData")
    public String changeUserData(@Param("name")String name,
                                 @Param("surname")String surname,
                                 @Param("patronymic")String patronymic,
                                 @Param("phone") String phone,
//                                 @Param("mail")String mail,
//                                 @Param("password") String password,
                                 @AuthenticationPrincipal Principal user){
        ManEntity man = manRepository.findByMail(user.getName());
        man.setName(name);
        man.setSurname(surname);
        man.setPatronymic(patronymic);
        man.setPhone(phone);

        return registered.changeUserData(man);
    }


}