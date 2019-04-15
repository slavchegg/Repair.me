package com.coursework.repair.replies;

import lombok.Data;

@Data
public class AuthReply {
    String message;
    String role;
    boolean serviceAdmin;
    String serviceName;
}
