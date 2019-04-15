package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.ServiceEntity;
import com.coursework.repair.replies.ServiceReply;
import com.coursework.repair.service.ServiceInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceInfoImpl implements ServiceInfoService {


// специализация сервиса = марки машин
    @Override
    public List<String> getMakes(ServiceEntity serviceEntity) {
        List<String> makes = new ArrayList<>();
        serviceEntity.getServiceModelsById().forEach(e->{
            if (!makes.contains(
                    e.getCarModelByModelsId().getCarMakeByMakeId().getName())
                    ) makes.add(e.getCarModelByModelsId().getCarMakeByMakeId().getName());
        });
        return makes;
    }

// специализация сервиса = модели, на которых специализируется сервис
    @Override
    public List<String> getModels(ServiceEntity serviceEntity) {
        List<String> models = new ArrayList<>();
        serviceEntity.getServiceModelsById().forEach(e->{
            models.add(e.getCarModelByModelsId().getName());
        });
        return models;
    }


}
