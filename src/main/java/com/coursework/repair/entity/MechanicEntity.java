package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "mechanic", schema = "public", catalog = "postgres")
public class MechanicEntity {
    private long id;
    private Long manId;
    private Boolean isApprove;
    private Long licenceId;
    private Boolean admin;
    private Long serviceId;
    private String post;
    private String about;
    private Collection<DialogEntity> dialogsById;
    private Collection<ExactRequestEntity> exactRequestsById;
    private ManEntity manByManId;
    private LicenceEntity licenceByLicenceId;
    private ServiceEntity serviceByServiceId;
    private Collection<MechanicModificationEntity> mechanicModificationsById;
    private Collection<UnitEntity> unitsById;

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
    @Column(name = "man_id")
    public Long getManId() {
        return manId;
    }

    public void setManId(Long manId) {
        this.manId = manId;
    }

    @Basic
    @Column(name = "is_approve")
    public Boolean getApprove() {
        return isApprove;
    }

    public void setApprove(Boolean approve) {
        isApprove = approve;
    }

    @Basic
    @Column(name = "licence_id")
    public Long getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(Long licenceId) {
        this.licenceId = licenceId;
    }

    @Basic
    @Column(name = "admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Basic
    @Column(name = "service_id")
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MechanicEntity that = (MechanicEntity) o;
        return id == that.id &&
                Objects.equals(manId, that.manId) &&
                Objects.equals(isApprove, that.isApprove) &&
                Objects.equals(licenceId, that.licenceId) &&
                Objects.equals(admin, that.admin) &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(post, that.post) &&
                Objects.equals(about, that.about);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, manId, isApprove, licenceId, admin, serviceId, post, about);
    }

    @OneToMany(mappedBy = "mechanicByMechanicId")
    public Collection<DialogEntity> getDialogsById() {
        return dialogsById;
    }

    public void setDialogsById(Collection<DialogEntity> dialogsById) {
        this.dialogsById = dialogsById;
    }

    @OneToMany(mappedBy = "mechanicByMechanicId")
    public Collection<ExactRequestEntity> getExactRequestsById() {
        return exactRequestsById;
    }

    public void setExactRequestsById(Collection<ExactRequestEntity> exactRequestsById) {
        this.exactRequestsById = exactRequestsById;
    }

    @ManyToOne
    @JoinColumn(name = "man_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ManEntity getManByManId() {
        return manByManId;
    }

    public void setManByManId(ManEntity manByManId) {
        this.manByManId = manByManId;
    }

    @ManyToOne
    @JoinColumn(name = "licence_id", referencedColumnName = "id", insertable = false, updatable = false)
    public LicenceEntity getLicenceByLicenceId() {
        return licenceByLicenceId;
    }

    public void setLicenceByLicenceId(LicenceEntity licenceByLicenceId) {
        this.licenceByLicenceId = licenceByLicenceId;
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ServiceEntity getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(ServiceEntity serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    @OneToMany(mappedBy = "mechanicByMechanicId")
    public Collection<MechanicModificationEntity> getMechanicModificationsById() {
        return mechanicModificationsById;
    }

    public void setMechanicModificationsById(Collection<MechanicModificationEntity> mechanicModificationsById) {
        this.mechanicModificationsById = mechanicModificationsById;
    }

    @OneToMany(mappedBy = "mechanicByMechanicId")
    public Collection<UnitEntity> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<UnitEntity> unitsById) {
        this.unitsById = unitsById;
    }
}
