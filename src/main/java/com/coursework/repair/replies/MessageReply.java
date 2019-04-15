package com.coursework.repair.replies;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


@Data
public class MessageReply {
    List<Message> messages;
    String context;

    @Data
    public static class Message{
        String interlocutor;
        Timestamp date;
        String content;
    }

}
