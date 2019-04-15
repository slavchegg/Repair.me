package com.coursework.repair.replies;

import com.coursework.repair.entity.ServiceEntity;
import lombok.Data;

import java.util.List;

@Data
public class ServiceReply {
    Service service;
    List<Mans> mechanics;

    @Data
    public static class Service{
        String name;
        String address;
        String hours;
        String photoHref;
        String phone;
        int rating;
        String href;
        String content;
    }

    @Data
    public static class Mans{
        long id ;
        String name;
        String surname;
        String photoHref;
        String post;
    }
}
