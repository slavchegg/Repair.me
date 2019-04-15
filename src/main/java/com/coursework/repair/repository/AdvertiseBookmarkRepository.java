package com.coursework.repair.repository;

import com.coursework.repair.entity.AdvertiseBookmarkEntity;
import com.coursework.repair.entity.ManEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertiseBookmarkRepository extends CrudRepository<AdvertiseBookmarkEntity,Integer> {
    List<AdvertiseBookmarkEntity> findByManByManId(ManEntity manByManId);
    List<AdvertiseBookmarkEntity> findById(long id);

}
