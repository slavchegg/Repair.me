package com.coursework.repair.replies;

import lombok.Data;

@Data
public class DialogReply {
    long dialogId;
    String interlocutor;
    String lastMessage;
    String topic;
    boolean isNew;

}