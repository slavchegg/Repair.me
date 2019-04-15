package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "advertise_bookmark", schema = "public", catalog = "postgres")
public class AdvertiseBookmarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Basic
//    @Column(name = "advertise_id")
//    private Long advertiseId;
//    @Basic
//
//    @Column(name = "man_id")
//    private Long manId;

    @ManyToOne
    @JoinColumn(name = "advertise_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AdvertiseEntity advertiseByAdvertiseId;


    @ManyToOne
    @JoinColumn(name = "man_id", referencedColumnName = "id" , insertable = false, updatable = false)
    private ManEntity manByManId;

}
