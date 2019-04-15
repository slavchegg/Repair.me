package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "unit_stage", schema = "public", catalog = "postgres")
public class UnitStageEntity {
    private long id;
    private String name;
    private Long unitId;
    private Long photoId;
    private UnitEntity unitByUnitId;
    private PhotoEntity photoByPhotoId;

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
    @Column(name = "unit_id")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "photo_id")
    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitStageEntity that = (UnitStageEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(photoId, that.photoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, unitId, photoId);
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", insertable = false, updatable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", insertable = false, updatable = false)
    public PhotoEntity getPhotoByPhotoId() {
        return photoByPhotoId;
    }

    public void setPhotoByPhotoId(PhotoEntity photoByPhotoId) {
        this.photoByPhotoId = photoByPhotoId;
    }
}
