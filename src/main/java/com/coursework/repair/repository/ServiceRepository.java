package com.coursework.repair.repository;;

import com.coursework.repair.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity,Integer> {
    ServiceEntity findById(Long id);
    List<ServiceEntity> findAll();

    // фильтры для поиска мастерских
    ServiceEntity findByName(String name);

    @Override
    <S extends ServiceEntity> S save(S s);
}