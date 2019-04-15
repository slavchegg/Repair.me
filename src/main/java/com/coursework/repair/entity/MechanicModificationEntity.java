package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mechanic_modification", schema = "public", catalog = "postgres")
public class MechanicModificationEntity {
    private long id;
    private Long mechanicId;
    private Long modificationId;
    private MechanicEntity mechanicByMechanicId;
    private CarModificationEntity carModificationByModificationId;

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
        MechanicModificationEntity that = (MechanicModificationEntity) o;
        return id == that.id &&
                Objects.equals(mechanicId, that.mechanicId) &&
                Objects.equals(modificationId, that.modificationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mechanicId, modificationId);
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
    @JoinColumn(name = "modification_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CarModificationEntity getCarModificationByModificationId() {
        return carModificationByModificationId;
    }

    public void setCarModificationByModificationId(CarModificationEntity carModificationByModificationId) {
        this.carModificationByModificationId = carModificationByModificationId;
    }
}
