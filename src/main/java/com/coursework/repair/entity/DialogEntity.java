package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "dialog", schema = "public", catalog = "postgres")
public class DialogEntity {
    private long id;
    private Long driverId;
    private Long mechanicId;
    private ManEntity manByDriverId;
    private MechanicEntity mechanicByMechanicId;
    private Collection<MessageEntity> messagesById;
    private String topic;

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
    @Column(name = "driver_id")
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "mechanic_id")
    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DialogEntity that = (DialogEntity) o;
        return id == that.id &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(mechanicId, that.mechanicId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, driverId, mechanicId);
    }

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ManEntity getManByDriverId() {
        return manByDriverId;
    }

    public void setManByDriverId(ManEntity manByDriverId) {
        this.manByDriverId = manByDriverId;
    }

    @ManyToOne
    @JoinColumn(name = "mechanic_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MechanicEntity getMechanicByMechanicId() {
        return mechanicByMechanicId;
    }

    public void setMechanicByMechanicId(MechanicEntity mechanicByMechanicId) {
        this.mechanicByMechanicId = mechanicByMechanicId;
    }

    @OneToMany(mappedBy = "dialogByDialogId")
    public Collection<MessageEntity> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<MessageEntity> messagesById) {
        this.messagesById = messagesById;
    }

    @Basic
    @Column(name = "topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
