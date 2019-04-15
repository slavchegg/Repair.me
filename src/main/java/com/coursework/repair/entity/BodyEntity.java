package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "body", schema = "public", catalog = "postgres")
public class BodyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "body_type")
    private String bodyType;

    @Basic
    @Column(name = "make")
    private String make;

    @Basic
    @Column(name = "material")
    private String material;

    @OneToMany(mappedBy = "bodyByBodyId")
    private Collection<AnatomyEntity> anatomiesById;

}
