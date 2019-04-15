package com.coursework.repair.repository;

import com.coursework.repair.entity.CarModificationEntity;
import com.coursework.repair.entity.MechanicEntity;
import com.coursework.repair.entity.MechanicModificationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MechanicModificationRepository extends CrudRepository<MechanicModificationEntity,Integer> {
    // для рассылки запросов механикам (поиск механиков, которые разибираются в модификациии)
    List<MechanicModificationEntity> findAllByCarModificationByModificationId(CarModificationEntity carModificationByModificationId);
    // отображение странцицы механика - все его интересы
    List<MechanicModificationEntity> findAllByMechanicByMechanicId(MechanicEntity mechanicByMechanicId);

}