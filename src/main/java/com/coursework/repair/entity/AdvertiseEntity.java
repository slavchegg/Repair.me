package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "advertise", schema = "public", catalog = "postgres")
public class AdvertiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "detail_id")
    private Long detailId;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "seller_id")
    private Long sellerId;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "adress")
    private String adress;

    @Basic
    @Column(name = "condition")
    private String condition;

    @Basic
    @Column(name = "price")
    private BigInteger price;

    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id",insertable = false, updatable = false)
    private DetailEntity detailByDetailId;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ManEntity manBySellerId;

    @OneToMany(mappedBy = "advertiseByAdvertiseId")
    private Collection<AdvertiseBookmarkEntity> advertiseBookmarksById;

}