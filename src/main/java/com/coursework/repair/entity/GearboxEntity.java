package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "gearbox", schema = "public", catalog = "postgres")
public class GearboxEntity {
    private long id;
    private String type;
    private String maker;
    private String model;
    private Integer speed;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "maker")
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
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
    @Column(name = "speed")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GearboxEntity that = (GearboxEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(maker, that.maker) &&
                Objects.equals(model, that.model) &&
                Objects.equals(speed, that.speed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, maker, model, speed);
    }

    @OneToMany(mappedBy = "gearboxByGearboxId")
    public Collection<AnatomyEntity> getAnatomiesById() {
        return anatomiesById;
    }

    public void setAnatomiesById(Collection<AnatomyEntity> anatomiesById) {
        this.anatomiesById = anatomiesById;
    }
}
