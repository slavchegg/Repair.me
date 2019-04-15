package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detail_modification", schema = "public", catalog = "postgres")
public class DetailModificationEntity {
    private long id;
    private Long detailId;
    private Long modificationId;
    private DetailEntity detailByDetailId;
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
    @Column(name = "detail_id")
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
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
        DetailModificationEntity that = (DetailModificationEntity) o;
        return id == that.id &&
                Objects.equals(detailId, that.detailId) &&
                Objects.equals(modificationId, that.modificationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, detailId, modificationId);
    }

    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    public DetailEntity getDetailByDetailId() {
        return detailByDetailId;
    }

    public void setDetailByDetailId(DetailEntity detailByDetailId) {
        this.detailByDetailId = detailByDetailId;
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
