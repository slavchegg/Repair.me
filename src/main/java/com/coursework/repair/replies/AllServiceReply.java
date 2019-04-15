package com.coursework.repair.replies;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class AllServiceReply {

    private String name;
    private int rating;
    private String photoHref;
    private long state;
    private List<String> makes;
    private String address;

}
