package com.coursework.repair.repository;

import com.coursework.repair.entity.PhotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends CrudRepository<PhotoEntity,Integer> {
    PhotoEntity findById (long id); // находим фотку по ид
    List<PhotoEntity> findAll(); // выбор всех фоток (ид)

    @Override
    <S extends PhotoEntity> S save(S s);
}
