package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exact_request", schema = "public", catalog = "postgres")
public class ExactRequestEntity {
    private long id;
    private Long mechanicId;
    private Long carId;
    private String content;
    private MechanicEntity mechanicByMechanicId;
    private CarEntity carByCarId;

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
    @Column(name = "mechanic_id")
    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    @Basic
    @Column(name = "car_id")
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExactRequestEntity that = (ExactRequestEntity) o;
        return id == that.id &&
                Objects.equals(mechanicId, that.mechanicId) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mechanicId, carId, content);
    }

    @ManyToOne
    @JoinColumn(name = "mechanic_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MechanicEntity getMechanicByMechanicId() {
        return mechanicByMechanicId;
    }

    public void setMechanicByMechanicId(MechanicEntity mechanicByMechanicId) {
        this.mechanicByMechanicId = mechanicByMechanicId;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "vin", insertable = false, updatable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }
}
