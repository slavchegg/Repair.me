package com.coursework.repair.repository;

import com.coursework.repair.entity.CarModelEntity;
import com.coursework.repair.entity.ServiceModelsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceModelRepository extends CrudRepository<ServiceModelsEntity,Integer> {
    // поиск сервисов, которые занимаются с данной моделью
    List<ServiceModelsEntity> findAllByCarModelByModelsId(CarModelEntity carModelByModelId);

}