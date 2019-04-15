package com.coursework.repair.repository;

import com.coursework.repair.entity.CarModificationEntity;
import com.coursework.repair.entity.DetailModificationEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailModificationRepository extends CrudRepository<DetailModificationEntity,Integer> {
    List<DetailModificationEntity> findAllByCarModificationByModificationId(CarModificationEntity carModificationByModificationId);
}
