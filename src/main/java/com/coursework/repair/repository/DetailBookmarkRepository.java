package com.coursework.repair.repository;

import com.coursework.repair.entity.DetailBookmarkEntity;
import com.coursework.repair.entity.ManEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailBookmarkRepository extends CrudRepository<DetailBookmarkEntity,Integer> {
    List<DetailBookmarkEntity> findAllByManByManId(ManEntity manEntity);
    List<DetailBookmarkEntity> findById(long id);
}
