package com.coursework.repair.repository;


import com.coursework.repair.entity.CarMakeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarMakeRepository extends CrudRepository<CarMakeEntity,Integer> {
    List<CarMakeEntity> findAll();
    CarMakeEntity findByName(String name);

    List<CarMakeEntity> findAllByName(String name);
}