package com.coursework.repair.controller;

import com.coursework.repair.repository.AnatomyRepository;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    //todo: добавить сюда запросы для заполнения марок, моделей,  модификаций,

    private final AnatomyRepository anatomyRepository;

    @Autowired
    public TestController(AnatomyRepository anatomyRepository) {
        this.anatomyRepository = anatomyRepository;
    }

    @RequestMapping("/getRole")
    public String getRole(@Param("number") int number){
        String reply = " ";
        StringBuilder str = new StringBuilder();
        switch (number){
            case 0: { // details (about session id, remoteIp address)
                Object o = SecurityContextHolder.getContext().getAuthentication().getDetails();
                return o.toString();
            }
            case 1: { // array of roles
                str.append("Roles: ");
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(role->{
                    str.append(role.toString());
                });
                reply = str.toString();
                return reply;
            }
            case 2: { // logout
//                SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
                SecurityContextHolder.clearContext();
                return "Successful logout";
            }
            default: return "incorrect number";
        }
    }




//    @Secured("ROLE_GUEST")
    @GetMapping("/getName")
    public String testAuth(@AuthenticationPrincipal Principal user){
        if (user.getName() == null ) return  "nobody authorized";
        else return "Your name is " + user.getName();
    }
    // if nobody auth , name = null ;


    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/isAnonim")
    public String test(@Param("id")long id){
        return "Successful test: you are anonim ";
    }


    @Secured("ROLE_DRIVER")
    @GetMapping("/isDriver")
    public String test2(){
        return "Successful test: you have driver role" ;
    }


    @Secured("ROLE_MECHANIC")
    @RequestMapping("/isMechanic")
    public String testMechanic(){
        return "Successful test: you have mechanic role";
    }

    @Secured("ROLE_SADMIN")
    @RequestMapping("/isSerAdmin")
    public String testSerAdmin(){
        return "Successful test: you have service admin role";
    }
}