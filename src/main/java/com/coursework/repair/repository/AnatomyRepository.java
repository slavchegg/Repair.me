package com.coursework.repair.repository;

import com.coursework.repair.entity.AnatomyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnatomyRepository extends CrudRepository<AnatomyEntity,Integer> {
    AnatomyEntity findById (long id);
}
