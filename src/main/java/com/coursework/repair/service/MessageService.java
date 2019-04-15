package com.coursework.repair.service;

import com.coursework.repair.entity.*;
import com.coursework.repair.replies.DialogReply;
import com.coursework.repair.replies.MechanicRequestReply;
import com.coursework.repair.replies.MessageReply;
import com.coursework.repair.replies.UserRequestReply;

import java.util.List;

public interface MessageService {
    String messageForService(long carId, ServiceEntity serviceEntity, String content );
    String messageForMechanic(long carId, MechanicEntity mechanicEntity, String content );
    String request (CarEntity car, String content);
    String guestRequest(String modification, String content);

    List<MechanicRequestReply> getGeneralRequests(MechanicEntity mechanic);
    List<MechanicRequestReply> getPrivateRequests(MechanicEntity mechanic);

    List<DialogReply> readMechanicDialogs(MechanicEntity mechanic);
    List<DialogReply> readUserDialogs(ManEntity man);

    List<MessageReply.Message> readUserMessages(long dialogId);
    List<MessageReply.Message> readMechanicMessages(long dialogId);

    String writeMessage(ManEntity man, long dialogId,String content);
    String writeMessage(MechanicEntity mechanic, long dialogId,String content);


    String decisionRequest(boolean decision,  RequestEntity request, MechanicEntity mechanic);
    String decisionExactRequest(boolean decision,  ExactRequestEntity request);

    List<UserRequestReply> getUserRequests(ManEntity man);
}
