package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "public", catalog = "postgres")
public class RequestEntity {
    private long id;
    private String node;
    private Long carId;
    private String content;
    private CarEntity carByCarId;

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
    @Column(name = "node")
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Basic
    @Column(name = "car_id")
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id == that.id &&
                Objects.equals(node, that.node) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, node, carId, content);
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "vin", insertable = false, updatable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }
}
