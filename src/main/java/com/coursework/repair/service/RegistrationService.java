package com.coursework.repair.service;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.ServiceEntity;
import org.springframework.stereotype.Service;

public interface RegistrationService {
    String regDriver(ManEntity man, String photoHref);
    String regMechanic(ManEntity man, String photoHref, MechanicEntity mechanic);
    // по массиву имен модификаций будут созданы записи в бд
    String regMechanicModification(long mechanicId,String[] modifications);
    String regService(MechanicEntity mechanic, String photoHref, ServiceEntity service);
    String regNewCar(long vin, long manId, long modificationId);


    String changeUserData(ManEntity man);
    String changeMail(String mail);
    String changePassword(String password);

}
