package com.coursework.repair.repository;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.entity.ServiceBookmarkEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceBookmarkRepository extends CrudRepository<ServiceBookmarkEntity,Integer> {
    List<ServiceBookmarkEntity> findAllByManByManId(ManEntity manByManId);
    List<ServiceBookmarkEntity> findById (long id);

}