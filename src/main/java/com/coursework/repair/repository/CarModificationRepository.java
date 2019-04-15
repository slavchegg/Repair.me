package com.coursework.repair.repository;

import com.coursework.repair.entity.CarModelEntity;
import com.coursework.repair.entity.CarModificationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModificationRepository extends CrudRepository<CarModificationEntity,Integer> {
    // выбор марки (при регистрации машины)
    List<CarModificationEntity> findAllByModel(Long model);
    List<CarModificationEntity> findAllByYear(Integer year);
    List<CarModificationEntity> findAllByModelAndYear(Long model, Integer year);

    // i can do it, only if i know the model !
    CarModificationEntity findByName(String name);
    // all modifications of one model
    List<CarModificationEntity> findAllByCarModelByModel(CarModelEntity carModelByModel);

    CarModificationEntity findByModelAndName(Long model, String name);
    // при запросе о консультации
    CarModificationEntity findById(long id);

}