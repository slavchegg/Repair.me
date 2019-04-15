package com.coursework.repair.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "car_model", schema = "public", catalog = "postgres")
public class CarModelEntity {
    private long id;
    private Long makeId;
    private String name;
    private String generation;
    private CarMakeEntity carMakeByMakeId;
    private Collection<CarModificationEntity> carModificationsById;
    private Collection<ServiceModelsEntity> serviceModelsById;

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
    @Column(name = "make_id")
    public Long getMakeId() {
        return makeId;
    }

    public void setMakeId(Long makeId) {
        this.makeId = makeId;
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
    @Column(name = "generation")
    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModelEntity that = (CarModelEntity) o;
        return id == that.id &&
                Objects.equals(makeId, that.makeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(generation, that.generation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, makeId, name, generation);
    }

    @ManyToOne
    @JoinColumn(name = "make_id", referencedColumnName = "id" , insertable = false , updatable = false)
    public CarMakeEntity getCarMakeByMakeId() {
        return carMakeByMakeId;
    }

    public void setCarMakeByMakeId(CarMakeEntity carMakeByMakeId) {
        this.carMakeByMakeId = carMakeByMakeId;
    }

    @OneToMany(mappedBy = "carModelByModel")
    public Collection<CarModificationEntity> getCarModificationsById() {
        return carModificationsById;
    }

    public void setCarModificationsById(Collection<CarModificationEntity> carModificationsById) {
        this.carModificationsById = carModificationsById;
    }

    @OneToMany(mappedBy = "carModelByModelsId")
    public Collection<ServiceModelsEntity> getServiceModelsById() {
        return serviceModelsById;
    }

    public void setServiceModelsById(Collection<ServiceModelsEntity> serviceModelsById) {
        this.serviceModelsById = serviceModelsById;
    }
}
