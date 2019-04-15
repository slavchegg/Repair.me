package com.coursework.repair.repository;

import com.coursework.repair.entity.CarEntity;
import com.coursework.repair.entity.RequestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity,Integer> {
    List<RequestEntity> findAllByCarByCarId(CarEntity carByCarId);

    RequestEntity findById(long id);
    @Override
    <S extends RequestEntity> S save(S s);

    @Override
    void delete(RequestEntity requestEntity);

}