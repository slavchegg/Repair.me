package com.coursework.repair.service;

import com.coursework.repair.entity.AdvertiseEntity;
import com.coursework.repair.entity.CarModificationEntity;
import com.coursework.repair.entity.DetailEntity;
import com.coursework.repair.replies.AdvertiseReply;

import java.util.List;

public interface AdvertiseService {
    List<AdvertiseReply> getAll();
    String addNew(AdvertiseEntity advertise, DetailEntity detail, CarModificationEntity modification);
}
