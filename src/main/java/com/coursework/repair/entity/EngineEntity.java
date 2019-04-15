package com.coursework.repair.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "engine", schema = "public", catalog = "postgres")
public class EngineEntity {
    private long id;
    private String name;
    private BigInteger volume;
    private int power;
    private int torque;
    private Boolean turbo;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "volume")
    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "power")
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Basic
    @Column(name = "torque")
    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    @Basic
    @Column(name = "turbo")
    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineEntity that = (EngineEntity) o;
        return id == that.id &&
                power == that.power &&
                torque == that.torque &&
                Objects.equals(name, that.name) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(turbo, that.turbo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, volume, power, torque, turbo);
    }

    @OneToMany(mappedBy = "engineByEngineId")
    public Collection<AnatomyEntity> getAnatomiesById() {
        return anatomiesById;
    }

    public void setAnatomiesById(Collection<AnatomyEntity> anatomiesById) {
        this.anatomiesById = anatomiesById;
    }
}
