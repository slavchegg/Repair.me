package com.coursework.repair.repository;

import com.coursework.repair.entity.BodyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BodyRepository extends CrudRepository<BodyEntity, Integer> {
    BodyRepository findById(long id);
}

