package com.coursework.repair.repository;

import com.coursework.repair.entity.CarMakeEntity;
import com.coursework.repair.entity.CarModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends CrudRepository<CarModelEntity, Integer> {
    List<CarModelEntity> findAllByMakeId(Long makeId);
    List<CarModelEntity> findAllByCarMakeByMakeId(CarMakeEntity carMakeByMakeId);
    CarModelEntity findByName(String name);

    CarModelEntity findByNameAndGeneration(String name, String generation);

    // выбор модификаций для механика
    List<CarModelEntity> findAllByMakeIdAndGeneration(Long makeId, String generation);

}
