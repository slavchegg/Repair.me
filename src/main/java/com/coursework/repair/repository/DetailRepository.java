package com.coursework.repair.repository;

import com.coursework.repair.entity.DetailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailRepository extends CrudRepository<DetailEntity,Integer> {
    DetailEntity findById(long id);
    DetailEntity findAllByNode(String number);

    List<DetailEntity> findAll();

}