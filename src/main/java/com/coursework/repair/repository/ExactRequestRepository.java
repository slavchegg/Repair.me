package com.coursework.repair.repository;

import com.coursework.repair.entity.CarEntity;
import com.coursework.repair.entity.ExactRequestEntity;

import com.coursework.repair.entity.MechanicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExactRequestRepository extends CrudRepository<ExactRequestEntity,Integer> {
    @Override
    <S extends ExactRequestEntity> S save(S s);

    @Override
    void delete(ExactRequestEntity exactRequestEntity);

    ExactRequestEntity findById(long id);
    // для отображения всех запросов мастеру
    List<ExactRequestEntity> findAllByMechanicByMechanicId(MechanicEntity mechanicByMechanicId);
    // для отображения всех запросов по одной машине
    List<ExactRequestEntity> findAllByCarByCarId(CarEntity carByCarId);
}
