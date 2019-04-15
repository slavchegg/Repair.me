package com.coursework.repair.repository;

import com.coursework.repair.entity.UnitEntity;
import com.coursework.repair.entity.UnitStageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitStageRepository extends CrudRepository<UnitStageEntity,Integer> {
    // поиск всех шагов ремонта
    List<UnitStageEntity> findAllByUnitByUnitId(UnitEntity unitByUnitId);

}