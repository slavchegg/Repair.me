package com.coursework.repair.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "unit", schema = "public", catalog = "postgres")
public class UnitEntity {
    private long id;
    private String name;
    private Long mechanicId;
    private Long carId;
    private Timestamp requestDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer total;
    private MechanicEntity mechanicByMechanicId;
    private CarEntity carByCarId;
    private Collection<UnitStageEntity> unitStagesById;

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
    @Column(name = "request_date")
    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "total")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitEntity that = (UnitEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(mechanicId, that.mechanicId) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(requestDate, that.requestDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, mechanicId, carId, requestDate, startDate, endDate, total);
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
    @JoinColumn(name = "car_id", referencedColumnName = "vin" , insertable = false, updatable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<UnitStageEntity> getUnitStagesById() {
        return unitStagesById;
    }

    public void setUnitStagesById(Collection<UnitStageEntity> unitStagesById) {
        this.unitStagesById = unitStagesById;
    }
}
