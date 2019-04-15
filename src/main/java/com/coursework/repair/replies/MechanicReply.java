package com.coursework.repair.replies;

import com.coursework.repair.entity.MechanicEntity;
import lombok.Data;

import java.util.List;

@Data
public class MechanicReply {
//    MechanicEntity mechanic;

//    private Boolean isApprove;
//    private Long licenceId;
    Boolean admin;
//    private Long serviceId;
    String post;
    String about;

    String name;
    String photoHref;
    String serviceName;

    List<String> makes;

}
