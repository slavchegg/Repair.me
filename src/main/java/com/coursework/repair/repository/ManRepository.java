package com.coursework.repair.repository;

import com.coursework.repair.entity.ManEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManRepository extends CrudRepository<ManEntity,Integer> {
    ManEntity findByMail(String mail); // проверка уникальности
    ManEntity findById(long id);

    ManEntity findByMailAndPassword(String mail, String password);

    @Override
    <S extends ManEntity> S save(S s);
}
