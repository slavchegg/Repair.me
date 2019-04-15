package com.coursework.repair.service;

import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.replies.CarReply;

import java.util.ArrayList;
import java.util.List;

public interface MakesService {
    ArrayList<String> getAllMakes();
    ArrayList<String> getAllModelsByMakes(String makeName);
    ArrayList<String> getAllModificationByModel(String modelName);

    List<CarReply> getAllUserCars(ManEntity man);
}
