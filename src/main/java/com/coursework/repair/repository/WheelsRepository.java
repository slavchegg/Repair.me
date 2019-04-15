package com.coursework.repair.repository;

import com.coursework.repair.entity.WheelsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WheelsRepository extends CrudRepository<WheelsEntity,Integer> {
    List<WheelsEntity> findAllByName(String name);
    List<WheelsEntity> findAllByNameAndRadius(String name, Integer radius);

}