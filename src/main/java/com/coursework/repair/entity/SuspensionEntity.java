package com.coursework.repair.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "suspension", schema = "public", catalog = "postgres")
public class SuspensionEntity {
    private long id;
    private String make;
    private String model;
    private Boolean air;
    private Boolean magnetic;
    private BigInteger height;
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
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "air")
    public Boolean getAir() {
        return air;
    }

    public void setAir(Boolean air) {
        this.air = air;
    }

    @Basic
    @Column(name = "magnetic")
    public Boolean getMagnetic() {
        return magnetic;
    }

    public void setMagnetic(Boolean magnetic) {
        this.magnetic = magnetic;
    }

    @Basic
    @Column(name = "height")
    public BigInteger getHeight() {
        return height;
    }

    public void setHeight(BigInteger height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuspensionEntity that = (SuspensionEntity) o;
        return id == that.id &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(air, that.air) &&
                Objects.equals(magnetic, that.magnetic) &&
                Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, make, model, air, magnetic, height);
    }

    @OneToMany(mappedBy = "suspensionBySuspensionId")
    public Collection<AnatomyEntity> getAnatomiesById() {
        return anatomiesById;
    }

    public void setAnatomiesById(Collection<AnatomyEntity> anatomiesById) {
        this.anatomiesById = anatomiesById;
    }
}
