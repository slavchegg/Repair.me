package com.coursework.repair.repository;

import com.coursework.repair.entity.ElectronicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectronicRepository extends CrudRepository<ElectronicEntity,Integer> {
    List<ElectronicEntity> findAllByMake(String make);
    List<ElectronicEntity> findAllByMakeAndType(String make, String type);

}
