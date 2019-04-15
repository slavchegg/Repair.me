package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "photo", schema = "public", catalog = "postgres")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "photo_href")
    private String photoHref;
    @OneToMany(mappedBy = "photoByPhotoId")
    private Collection<ManEntity> menById;
    @OneToMany(mappedBy = "photoByPhotoId")
    private Collection<ServiceEntity> servicesById;
    @OneToMany(mappedBy = "photoByPhotoId")
    private Collection<UnitStageEntity> unitStagesById;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PhotoEntity that = (PhotoEntity) o;
//        return id == that.id &&
//                Objects.equals(photoHref, that.photoHref);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, photoHref);
//    }

//
//    public Collection<ManEntity> getMenById() {
//        return menById;
//    }
//
//    public void setMenById(Collection<ManEntity> menById) {
//        this.menById = menById;
//    }


//    public Collection<ServiceEntity> getServicesById() {
//        return servicesById;
//    }
//
//    public void setServicesById(Collection<ServiceEntity> servicesById) {
//        this.servicesById = servicesById;
//    }
//
//
//    public Collection<UnitStageEntity> getUnitStagesById() {
//        return unitStagesById;
//    }
//
//    public void setUnitStagesById(Collection<UnitStageEntity> unitStagesById) {
//        this.unitStagesById = unitStagesById;
//    }

}
