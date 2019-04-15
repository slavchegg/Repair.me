package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service_models", schema = "public", catalog = "postgres")
public class ServiceModelsEntity {
    private long id;
    private Long serviceId;
    private Long modelsId;
    private ServiceEntity serviceByServiceId;
    private CarModelEntity carModelByModelsId;

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
    @Column(name = "models_id")
    public Long getModelsId() {
        return modelsId;
    }

    public void setModelsId(Long modelsId) {
        this.modelsId = modelsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceModelsEntity that = (ServiceModelsEntity) o;
        return id == that.id &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(modelsId, that.modelsId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, serviceId, modelsId);
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
    @JoinColumn(name = "models_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CarModelEntity getCarModelByModelsId() {
        return carModelByModelsId;
    }

    public void setCarModelByModelsId(CarModelEntity carModelByModelsId) {
        this.carModelByModelsId = carModelByModelsId;
    }
}
