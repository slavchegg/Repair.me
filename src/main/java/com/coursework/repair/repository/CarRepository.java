package com.coursework.repair.repository;

import com.coursework.repair.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<CarEntity, Integer> {
    List<CarEntity> findAllByDriverId(Long driverId);
    CarEntity findByVin(long vin);

}