package com.coursework.repair.repository;

import com.coursework.repair.entity.DialogEntity;
import com.coursework.repair.entity.MechanicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DialogRepository extends CrudRepository<DialogEntity,Integer> {
    DialogEntity findById(long id);
    // поиск диалогов пользователя
    List<DialogEntity> findAllByDriverId(Long driverId);
    // поиск диалогов мастера
    List<DialogEntity> findAllByMechanicByMechanicId(MechanicEntity mechanicByMechanicId);

    @Override
    <S extends DialogEntity> S save(S s);
}