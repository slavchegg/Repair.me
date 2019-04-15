package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "licence", schema = "public", catalog = "postgres")
public class LicenceEntity {
    private long id;
    private String licenceHref;
    private Collection<MechanicEntity> mechanicsById;

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
    @Column(name = "licence_href")
    public String getLicenceHref() {
        return licenceHref;
    }

    public void setLicenceHref(String licenceHref) {
        this.licenceHref = licenceHref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenceEntity that = (LicenceEntity) o;
        return id == that.id &&
                Objects.equals(licenceHref, that.licenceHref);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, licenceHref);
    }

    @OneToMany(mappedBy = "licenceByLicenceId")
    public Collection<MechanicEntity> getMechanicsById() {
        return mechanicsById;
    }

    public void setMechanicsById(Collection<MechanicEntity> mechanicsById) {
        this.mechanicsById = mechanicsById;
    }
}
