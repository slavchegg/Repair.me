package com.coursework.repair.repository;

import com.coursework.repair.entity.DialogEntity;
import com.coursework.repair.entity.MessageEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageEntity,Integer> {
    // поиск сообщений диалога
    List<MessageEntity> findAllByDialogByDialogId(DialogEntity dialogEntity);

    // проверка наличия новых сообщений в диалоге
    List<MessageEntity> findAllByDialogByDialogIdAndUserread(DialogEntity dialogByDialogId, Boolean userRead);
    List<MessageEntity> findAllByDialogByDialogIdAndMechread(DialogEntity dialogByDialogId, Boolean mechRead);


    @Override
    <S extends MessageEntity> S save(S s);
}