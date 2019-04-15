package com.coursework.repair.service;

import com.coursework.repair.replies.AuthReply;

public interface AuthService {
    boolean login(String username, String password) ;
    AuthReply getDetails(boolean auth);
    String logout();
}
