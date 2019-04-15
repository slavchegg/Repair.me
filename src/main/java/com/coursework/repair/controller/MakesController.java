package com.coursework.repair.controller;

import com.coursework.repair.serviceImpl.MakesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


 // checked controller

@RestController
public class MakesController {

    private final MakesImpl makes;

    @Autowired
    public MakesController(MakesImpl makes) {
        this.makes = makes;
    }


    @RequestMapping("/getAllMakes")
    public ArrayList<String> getAllMakes(){
        return  makes.getAllMakes();
    }

    @RequestMapping("/getAllModels")
    public ArrayList<String> getAllModels(@Param("makeName")String makeName){
        return makes.getAllModelsByMakes(makeName);
    }

    @RequestMapping("/getAllModifications")
    public ArrayList<String> getAllModifications(@Param("modelName")String modelName){
        return makes.getAllModificationByModel(modelName);
    }
}
