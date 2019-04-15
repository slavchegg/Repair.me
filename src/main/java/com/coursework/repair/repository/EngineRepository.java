package com.coursework.repair.repository;

import com.coursework.repair.entity.EngineEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface EngineRepository extends CrudRepository<EngineEntity,Integer> {
    List<EngineEntity> findAllByName(String name);
}
