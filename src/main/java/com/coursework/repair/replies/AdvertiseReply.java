package com.coursework.repair.replies;

import com.coursework.repair.entity.AdvertiseEntity;
import lombok.Data;

@Data
public class AdvertiseReply {
    AdvertiseEntity advertise;
    String detailName;
    String detailNode;
}
