package com.coursework.repair.controller;

import com.coursework.repair.replies.AdvertiseReply;
import com.coursework.repair.service.AdvertiseService;
import com.coursework.repair.serviceImpl.AdvertiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/advertise")
public class AvitoController {

    private final AdvertiseImpl advertise;

    @Autowired
    public AvitoController(AdvertiseImpl advertise) {
        this.advertise = advertise;
    }

    @RequestMapping("/getAll")
    public List<AdvertiseReply> getAllAdvertises(){
        return advertise.getAll();
    }

    @RequestMapping("/addNew")
    public String createNewAdvert(@Param("topic")String topic,
                                  @Param("description")String description,
                                  @Param("address")String address,
                                  @Param("condition") String condition ,
                                  @Param("price")BigInteger price,
                                  @Param("detailName")String detailName
                                  ) {
        return null;
    }

}
