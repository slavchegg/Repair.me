package com.coursework.repair.repository;

import com.coursework.repair.entity.LicenceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenceRepository extends CrudRepository<LicenceEntity,Integer> {
    LicenceEntity findById(long id);
    List<LicenceEntity> findAll();

}
