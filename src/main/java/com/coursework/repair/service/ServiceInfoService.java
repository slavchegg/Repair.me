package com.coursework.repair.service;

import com.coursework.repair.entity.ServiceEntity;
import com.coursework.repair.replies.ServiceReply;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceInfoService {

    List<String> getMakes(ServiceEntity serviceEntity);
    List<String> getModels(ServiceEntity serviceEntity);

//    ServiceReply findServiceByName(String name);
}
