package com.coursework.repair.controller;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.ServiceEntity;
import com.coursework.repair.replies.AuthReply;
import com.coursework.repair.repository.*;
import com.coursework.repair.serviceImpl.AuthImpl;
import com.coursework.repair.serviceImpl.MakesImpl;
import com.coursework.repair.serviceImpl.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final ManRepository manRepository;
    private final MechanicRepository mechanicRepository;
    private final ServiceRepository serviceRepository;
    private final RegistrationServiceImpl registrationService;
    private final CarModificationRepository carModificationRepository;
    private final AuthImpl auth;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CarModelRepository carModelRepository;

    @Autowired
    public RegistrationController(ManRepository manRepository, ServiceRepository serviceRepository, MechanicRepository mechanicRepository, RegistrationServiceImpl registrationService, CarModificationRepository carModificationRepository, AuthImpl auth, BCryptPasswordEncoder passwordEncoder, CarModelRepository carModelRepository) {
        this.manRepository = manRepository;
        this.serviceRepository = serviceRepository;
        this.mechanicRepository = mechanicRepository;
        this.registrationService = registrationService;
        this.carModificationRepository = carModificationRepository;
        this.auth = auth;
        this.passwordEncoder = passwordEncoder;
        this.carModelRepository = carModelRepository;
    }

    @PostMapping("/login")
    public AuthReply login(@Param("username")String username,
                           @Param("password") String password){
//        System.out.println(" login method ");
//        SecurityContextHolder.getContext()
//                .setAuthentication(
//                        authenticationManager.authenticate(
//                                new UsernamePasswordAuthenticationToken(username, password)
//                        )
//                );
        return auth.getDetails(
                auth.login(username, password)
        );
    }

    @GetMapping("/logout")
    public String logout(){
        return auth.logout();
    }

    @PostMapping("/newDriver")
    public String regNewMan(@Param("name")String name,
                          @Param("surname")String surname,
                          @Param("patronymic")String patronymic,
                          @Param("mail")String mail,
                          @Param("phone") String phone,
                          @Param("photoHref") String photoHref,
                          @Param("password") String password){
        if (manRepository.findByMail(mail) != null) return "This mail has already registered! ";
        else {
            password = passwordEncoder.encode(password);

            ManEntity newMan = new ManEntity();
            newMan.setName(name);
            newMan.setSurname(surname);
            newMan.setPatronymic(patronymic);
            newMan.setMail(mail);
            newMan.setPhone(phone);
            newMan.setPassword(password);

            return registrationService.regDriver(newMan, photoHref);
        }
    }

    // there is a special name of service "no service" for mechanic, which doesn't work anywhere
    @GetMapping("/getServicesNames")
    public ArrayList<String> getServicesNames(){
        List<ServiceEntity> services = serviceRepository.findAll();
        ArrayList<String> serviceNames  = new ArrayList<>();
        services.forEach(e->serviceNames.add(e.getName()));
        return serviceNames;
    }



    // mail = test@mail , password = password


    // регистрация нового механика
    @PostMapping("/newMechanic")
    public String regNewMechanic(@Param("name")String name,
                                 @Param("surname")String surname,
                                 @Param("patronymic")String patronymic,
                                 @Param("mail")String mail,
                                 @Param("phone") String phone,
                                 @Param("photoHref") String photoHref,
                                 @Param("password") String password,
                                 @RequestParam(value = "serviceName", required=false, defaultValue="default")String serviceName,
                                 @Param("post")String post,
                                 @Param("about")String about){
        if (manRepository.findByMail(mail) != null ) return  "This mail has already registered";
        else {
            password = passwordEncoder.encode(password);

            ManEntity man = new ManEntity();
            man.setName(name);
            man.setSurname(surname);
            man.setPatronymic(patronymic);
            man.setMail(mail);
            man.setPhone(phone);
            man.setPassword(password);

            MechanicEntity mechanic = new MechanicEntity();
            mechanic.setAdmin(false);
            mechanic.setApprove(true);
            mechanic.setPost(post);
            mechanic.setAbout(about);
            mechanic.setServiceId(serviceRepository.findByName(serviceName).getId());

            return registrationService.regMechanic(man, photoHref, mechanic);
        }
    }

    // you can get list of modifications (String names of modifications) by MakesController
    // after approving mechanic
    @Secured("ROLE_MECHANIC")
    @RequestMapping("/regModifications")
    public String reMechanicModification(@AuthenticationPrincipal Principal user,
//                                         @Param("modifications")String[] modifications,
                                         @Param("makes")String[] makes){
        System.out.println("=== REGISTRATION MECHANIC MODIFICATION ===");
        for(String make: makes){
            System.out.println("make name: " + make + " ; ");
        }
        // we work with current user, it must be mechanic
        MechanicEntity mechanic = mechanicRepository.findByManByManId(
                manRepository.findByMail(user.getName())
        );
        return registrationService.regMechanicModification(
                mechanic.getId(),
//                modifications
                makes
        );

    }


    @Secured("ROLE_MECHANIC")
    @PostMapping("/newService")
    public String regNewService(@AuthenticationPrincipal Principal user,
                                @Param("name")String name,
//                                @Param("region")String region,
                                @Param("city")String city,
                                @Param("street")String street,
                                @Param("house")String house,
                                @Param("photoHref")String photoHref,
                                @Param("content")String content,
                                @Param("phone")String phone,
                                @Param("hours")String hours,
                                @Param("href") String href){
        MechanicEntity mechanic = mechanicRepository.findByManByManId(
                manRepository.findByMail(user.getName())
        );
        if (mechanic.getAdmin()) return "You are already administrator of service.";
        else {
            ServiceEntity service = new ServiceEntity();
            service.setName(name);
            service.setAdressRegion("Северо - Западный регион");
            service.setAdressCity(city);
            service.setAdressStreet(street);
            service.setAdressHouse(house);
            service.setHref(href);
            service.setContent(content);
            service.setHours(hours);
            service.setPhone(phone);

            return registrationService.regService(mechanic, photoHref, service);
        }
    }

    @Secured("ROLE_DRIVER")
    @PostMapping("/newCar")
    public String regNewCar(@AuthenticationPrincipal Principal user,
                            @Param("vin") long vin ,
                            @Param("modification")String modification,
                            @Param("model")String model){
        String[] s = model.split(" ");
        return registrationService.regNewCar(
                vin,
                manRepository.findByMail(user.getName()).getId(),
                carModificationRepository.findByModelAndName(
                        carModelRepository.findByNameAndGeneration(s[0],s[1]).getId(),
                        modification)
                        .getId()
        );
    }

}