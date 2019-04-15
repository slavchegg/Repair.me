package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car_modification", schema = "public", catalog = "postgres")
public class CarModificationEntity {
    private long id;
    private String name;
    private Long model;
    private Integer year;
    private String body;
    private Long anatomyId;
    private Collection<CarEntity> carsById;
    private CarModelEntity carModelByModel;
    private AnatomyEntity anatomyByAnatomyId;
    private Collection<DetailModificationEntity> detailModificationsById;
    private Collection<MechanicModificationEntity> mechanicModificationsById;

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
    @Column(name = "model")
    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "anatomy_id")
    public Long getAnatomyId() {
        return anatomyId;
    }

    public void setAnatomyId(Long anatomyId) {
        this.anatomyId = anatomyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModificationEntity that = (CarModificationEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(body, that.body) &&
                Objects.equals(anatomyId, that.anatomyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, model, year, body, anatomyId);
    }

    @OneToMany(mappedBy = "carModificationByModificationId")
    public Collection<CarEntity> getCarsById() {
        return carsById;
    }

    public void setCarsById(Collection<CarEntity> carsById) {
        this.carsById = carsById;
    }

    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "id", insertable = false, updatable = false)
    public CarModelEntity getCarModelByModel() {
        return carModelByModel;
    }

    public void setCarModelByModel(CarModelEntity carModelByModel) {
        this.carModelByModel = carModelByModel;
    }

    @ManyToOne
    @JoinColumn(name = "anatomy_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AnatomyEntity getAnatomyByAnatomyId() {
        return anatomyByAnatomyId;
    }

    public void setAnatomyByAnatomyId(AnatomyEntity anatomyByAnatomyId) {
        this.anatomyByAnatomyId = anatomyByAnatomyId;
    }

    @OneToMany(mappedBy = "carModificationByModificationId")
    public Collection<DetailModificationEntity> getDetailModificationsById() {
        return detailModificationsById;
    }

    public void setDetailModificationsById(Collection<DetailModificationEntity> detailModificationsById) {
        this.detailModificationsById = detailModificationsById;
    }

    @OneToMany(mappedBy = "carModificationByModificationId")
    public Collection<MechanicModificationEntity> getMechanicModificationsById() {
        return mechanicModificationsById;
    }

    public void setMechanicModificationsById(Collection<MechanicModificationEntity> mechanicModificationsById) {
        this.mechanicModificationsById = mechanicModificationsById;
    }
}
