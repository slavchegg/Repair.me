package com.coursework.repair.repository;

import com.coursework.repair.entity.AdvertiseEntity;
import com.coursework.repair.entity.DetailEntity;
import com.coursework.repair.entity.ManEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface AdvertiseRepository extends CrudRepository<AdvertiseEntity, Integer>{
    // поиск объявлений по интересующей детали
    List<AdvertiseEntity> findAllByDetailByDetailId(DetailEntity detailByDetailId);

    // поиск всех объявлений продавца
    List<AdvertiseEntity> findAllByManBySellerId(ManEntity manBySellerId);

    List<AdvertiseEntity> findAll();

}