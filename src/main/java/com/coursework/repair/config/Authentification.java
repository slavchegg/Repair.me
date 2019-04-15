package com.coursework.repair.config;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.repository.ManRepository;
import com.coursework.repair.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Authentification {

    private final ManRepository manRepository ;
    private final MechanicRepository mechanicRepository;

    @Autowired
    public Authentification(ManRepository manRepository, MechanicRepository mechanicRepository) {
        this.manRepository = manRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() {
        return authentication -> {
            System.out.println("=== AUTH MANAGER: === ");
            if (authentication.getName().isEmpty()) {
                System.out.println("You have guest role, because you have incorrect password or mail");
                return new UsernamePasswordAuthenticationToken(authentication.getName(),
                        authentication.getCredentials(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
            }
            else  {
                List<GrantedAuthority> roles = new ArrayList<>();
                ManEntity user = manRepository.findByMail(authentication.getName());
                if (!(user == null)){
                    if ( // man isn't mechanic or mechanic isn't approve
                            !user.getIsMechanic() ||
                            (user.getIsMechanic() && !mechanicRepository.findByManByManId(user).getApprove())
                    ){
                        System.out.println("role - driver");
                        roles.add(new SimpleGrantedAuthority("ROLE_DRIVER"));
                    }
                    else {
                        roles.add(new SimpleGrantedAuthority("ROLE_DRIVER"));
                        roles.add(new SimpleGrantedAuthority("ROLE_MECHANIC"));
                        System.out.println("role - mechanic");
                        if (mechanicRepository.findByManByManId(user).getAdmin()){
                            System.out.print(" and service admin") ;
                        }
                            roles.add(new SimpleGrantedAuthority("ROLE_SADMIN"));
                    }
                }else  System.out.println("User is null. But it impossible");

                System.out.println("\n=== FINISH AUTHORIZATION === ");
                return new UsernamePasswordAuthenticationToken(
                        authentication.getName(),
                        authentication.getCredentials(),
                        roles);
            }
        };
    }
}