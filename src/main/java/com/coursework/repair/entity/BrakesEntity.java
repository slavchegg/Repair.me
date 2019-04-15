package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "brakes", schema = "public", catalog = "postgres")
public class BrakesEntity {
    private long id;
    private String brakesType;
    private String name;
    private String type;
    private String material;
    private Integer diameter;
    private Integer piston;

    @OneToMany(mappedBy = "brakesByBrakesId")
    private Collection<AnatomyEntity> anatomiesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brakes_type")
    public String getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(String brakesType) {
        this.brakesType = brakesType;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "diameter")
    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "piston")
    public Integer getPiston() {
        return piston;
    }

    public void setPiston(Integer piston) {
        this.piston = piston;
    }

}
