package com.coursework.repair.repository;

import com.coursework.repair.entity.LightsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LightsRepository extends CrudRepository<LightsEntity,Integer> {
    List<LightsEntity> findAllByLightType(String lightType);
    List<LightsEntity> findAllByLightTypeAndMake(String lightType, String make);
}
