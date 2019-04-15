package com.coursework.repair.repository;

import com.coursework.repair.entity.BrakesEntity;
import org.springframework.data.repository.CrudRepository;

public interface BrakesRepository extends CrudRepository<BrakesEntity, Integer> {
    BrakesEntity findById(long id);

}
