package com.coursework.repair.replies;

import lombok.Data;

@Data
public class MechanicRequestReply {
    String sender;
    String content;
    String modification;
    long requestID;

}
