package com.coursework.repair.repository;

import com.coursework.repair.entity.GearboxEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GearboxRepository extends CrudRepository<GearboxEntity,Integer> {
    List<GearboxEntity> findAllByMaker(String maker);
}
