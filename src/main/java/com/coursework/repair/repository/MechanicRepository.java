package com.coursework.repair.repository;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends CrudRepository<MechanicEntity,Integer> {
    MechanicEntity findByManByManId(ManEntity manByManId);
    // ищем админа
    MechanicEntity findByServiceByServiceIdAndAdmin(ServiceEntity serviceByServiceId, Boolean admin);
    // ищем работников сервиса
    List<MechanicEntity> findByServiceByServiceId(ServiceEntity serviceByServiceId);
    MechanicEntity findById(long id);

    @Override
    <S extends MechanicEntity> S save(S s);



}