package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "postgres")
public class CarEntity {
    private long vin;
    private Long driverId;
    private Long modificationId;
    private ManEntity manByDriverId;
    private CarModificationEntity carModificationByModificationId;
    private Collection<ExactRequestEntity> exactRequestsByVin;
    private Collection<RequestEntity> requestsByVin;
    private Collection<UnitEntity> unitsByVin;

    @Id
    // vin is unique value (one var - one vin )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vin")
    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "driver_id")
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "modification_id")
    public Long getModificationId() {
        return modificationId;
    }

    public void setModificationId(Long modificationId) {
        this.modificationId = modificationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return vin == carEntity.vin &&
                Objects.equals(driverId, carEntity.driverId) &&
                Objects.equals(modificationId, carEntity.modificationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vin, driverId, modificationId);
    }

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ManEntity getManByDriverId() {
        return manByDriverId;
    }

    public void setManByDriverId(ManEntity manByDriverId) {
        this.manByDriverId = manByDriverId;
    }

    @ManyToOne
    @JoinColumn(name = "modification_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CarModificationEntity getCarModificationByModificationId() {
        return carModificationByModificationId;
    }

    public void setCarModificationByModificationId(CarModificationEntity carModificationByModificationId) {
        this.carModificationByModificationId = carModificationByModificationId;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<ExactRequestEntity> getExactRequestsByVin() {
        return exactRequestsByVin;
    }

    public void setExactRequestsByVin(Collection<ExactRequestEntity> exactRequestsByVin) {
        this.exactRequestsByVin = exactRequestsByVin;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<RequestEntity> getRequestsByVin() {
        return requestsByVin;
    }

    public void setRequestsByVin(Collection<RequestEntity> requestsByVin) {
        this.requestsByVin = requestsByVin;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<UnitEntity> getUnitsByVin() {
        return unitsByVin;
    }

    public void setUnitsByVin(Collection<UnitEntity> unitsByVin) {
        this.unitsByVin = unitsByVin;
    }
}
