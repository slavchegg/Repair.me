package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "enterior", schema = "public", catalog = "postgres")
public class EnteriorEntity {
    private long id;
    private String color;
    private String material;
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
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnteriorEntity that = (EnteriorEntity) o;
        return id == that.id &&
                Objects.equals(color, that.color) &&
                Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, color, material);
    }

    @OneToMany(mappedBy = "enteriorByEnteriorId")
    public Collection<AnatomyEntity> getAnatomiesById() {
        return anatomiesById;
    }

    public void setAnatomiesById(Collection<AnatomyEntity> anatomiesById) {
        this.anatomiesById = anatomiesById;
    }
}
