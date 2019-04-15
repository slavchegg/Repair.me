package com.coursework.repair.repository;

import com.coursework.repair.entity.SuspensionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SuspentionRepository extends CrudRepository<SuspensionEntity,Integer> {
    List<SuspensionEntity> findAllByMake(String make);
    List<SuspensionEntity> findAllByMakeAndModel(String make, String model);

}