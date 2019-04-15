package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service_bookmark", schema = "public", catalog = "postgres")
public class ServiceBookmarkEntity {
    private long id;
    private Long serviceId;
    private Long manId;
    private ServiceEntity serviceByServiceId;
    private ManEntity manByManId;

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
    @Column(name = "service_id")
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "man_id")
    public Long getManId() {
        return manId;
    }

    public void setManId(Long manId) {
        this.manId = manId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBookmarkEntity that = (ServiceBookmarkEntity) o;
        return id == that.id &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(manId, that.manId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, serviceId, manId);
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ServiceEntity getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(ServiceEntity serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "man_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ManEntity getManByManId() {
        return manByManId;
    }

    public void setManByManId(ManEntity manByManId) {
        this.manByManId = manByManId;
    }
}
