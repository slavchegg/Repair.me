package com.coursework.repair.repository;

import com.coursework.repair.entity.EnteriorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnteriorRepository extends CrudRepository<EnteriorEntity,Integer> {
    List<EnteriorEntity> findAllByMaterial(String material);

}