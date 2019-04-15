package com.coursework.repair.repository;

import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.UnitEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitRepository extends CrudRepository<UnitEntity,Integer> {
    // для страницы сервиса ищем его работы
    List<UnitEntity> findByMechanicByMechanicId(MechanicEntity mechanicByMechanicId);


}