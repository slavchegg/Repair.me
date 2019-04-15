package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.replies.AuthReply;
import com.coursework.repair.repository.ManRepository;
import com.coursework.repair.repository.MechanicRepository;
import com.coursework.repair.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AuthImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ManRepository manRepository;
    private final MechanicRepository mechanicRepository;

    @Autowired
    public AuthImpl(AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder, ManRepository manRepository, MechanicRepository mechanicRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.manRepository = manRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("AUTHORIZATION USER: ");
        boolean auth = true;
//        System.out.println(" ->  Mail -  " + username + "\n -> Password =  "+ password);

        System.out.println("    Details: ");
        if (manRepository.findByMail(username) == null) { // incorrect mail
            System.out.println("    * incorrect mail; ");
            username = "";
            auth = false;
        }else if (! passwordEncoder.matches(password,manRepository.findByMail(username).getPassword())) {
            // incorrect password
            // no such user = > username is empty
            System.out.println("    * incorrect  password; ");
            username = "";
            auth = false;
        }

        SecurityContextHolder.getContext()
                .setAuthentication(
                        authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        username,
                                        password)
                        )
                );
        return auth;

    }

    @Override
    public AuthReply getDetails(boolean auth) {
        AuthReply newUser = new AuthReply();
        if (!auth){
            newUser.setMessage("no such user");
            newUser.setRole("guest");
            return newUser;
        }
        else {
            // set roles and other details
            // we have driver, mechanic, serviceAdmin, admin , maybe moderator

            // get current user from context
            String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user);
            // user isn't a guest
            newUser.setMessage("Successful authorized");

            ManEntity man = manRepository.findByMail(user);
            if (!man.getIsMechanic()) newUser.setRole("driver");
            else {
                newUser.setRole("mechanic");
                MechanicEntity mechanic = mechanicRepository.findByManByManId(man);
                if (mechanic.getAdmin()) {
                    newUser.setRole("serviceAdmin");
                    newUser.setServiceAdmin(true);
                    newUser.setServiceName(mechanic.getServiceByServiceId().getName());
                }
            }
        }
        return newUser;
    }

    @Override
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Successful logout";
    }

}