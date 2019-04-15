package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "electronic", schema = "public", catalog = "postgres")
public class ElectronicEntity {
    private long id;
    private String make;
    private String type;
    private Collection<AnatomyEntity> anatomiesById;

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
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicEntity that = (ElectronicEntity) o;
        return id == that.id &&
                Objects.equals(make, that.make) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, make, type);
    }

    @OneToMany(mappedBy = "electronicByElectronicId")
    public Collection<AnatomyEntity> getAnatomiesById() {
        return anatomiesById;
    }

    public void setAnatomiesById(Collection<AnatomyEntity> anatomiesById) {
        this.anatomiesById = anatomiesById;
    }
}
