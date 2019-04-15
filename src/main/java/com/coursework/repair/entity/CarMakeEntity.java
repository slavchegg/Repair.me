package com.coursework.repair.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car_make", schema = "public", catalog = "postgres")
public class CarMakeEntity {
    private long id;
    private String name;
    private BigInteger popular;
    private String country;
    private Collection<CarModelEntity> carModelsById;

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
    @Column(name = "popular")
    public BigInteger getPopular() {
        return popular;
    }

    public void setPopular(BigInteger popular) {
        this.popular = popular;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMakeEntity that = (CarMakeEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(popular, that.popular) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, popular, country);
    }

    @OneToMany(mappedBy = "carMakeByMakeId")
    public Collection<CarModelEntity> getCarModelsById() {
        return carModelsById;
    }

    public void setCarModelsById(Collection<CarModelEntity> carModelsById) {
        this.carModelsById = carModelsById;
    }
}
