package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "man", schema = "public", catalog = "postgres")
public class ManEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "patronymic")
    private String patronymic;

    @Basic
    @Column(name = "mail")
    private String mail;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "photo_id")
    private Long photoId;

    @Basic
    @Column(name = "is_mechanic")
    private Boolean isMechanic;

    @OneToMany(mappedBy = "manBySellerId")
    private Collection<AdvertiseEntity> advertisesById;

    @OneToMany(mappedBy = "manByManId")
    private Collection<AdvertiseBookmarkEntity> advertiseBookmarksById;

    @OneToMany(mappedBy = "manByDriverId")
    private Collection<CarEntity> carsById;

    @OneToMany(mappedBy = "manByManId")
    private Collection<DetailBookmarkEntity> detailBookmarksById;

    @OneToMany(mappedBy = "manByDriverId")
    private Collection<DialogEntity> dialogsById;

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PhotoEntity photoByPhotoId;

    @OneToMany(mappedBy = "manByManId")
    private Collection<MechanicEntity> mechanicsById;

    @OneToMany(mappedBy = "manBySenderId")
    private Collection<MessageEntity> messagesById;

    @OneToMany(mappedBy = "manByManId")
    private Collection<ServiceBookmarkEntity> serviceBookmarksById;


//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public Long getPhotoId() {
//        return photoId;
//    }
//
//    public void setPhotoId(Long photoId) {
//        this.photoId = photoId;
//    }


//    public Boolean getMechanic() {
//        return isMechanic;
//    }
//
//    public void setMechanic(Boolean mechanic) {
//        isMechanic = mechanic;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ManEntity manEntity = (ManEntity) o;
//        return id == manEntity.id &&
//                Objects.equals(name, manEntity.name) &&
//                Objects.equals(surname, manEntity.surname) &&
//                Objects.equals(patronymic, manEntity.patronymic) &&
//                Objects.equals(mail, manEntity.mail) &&
//                Objects.equals(phone, manEntity.phone) &&
//                Objects.equals(password, manEntity.password) &&
//                Objects.equals(photoId, manEntity.photoId) &&
//                Objects.equals(isMechanic, manEntity.isMechanic);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, surname, patronymic, mail, phone, password, photoId, isMechanic);
//    }

//
//    public Collection<AdvertiseEntity> getAdvertisesById() {
//        return advertisesById;
//    }
//
//    public void setAdvertisesById(Collection<AdvertiseEntity> advertisesById) {
//        this.advertisesById = advertisesById;
//    }
//
//
//    public Collection<AdvertiseBookmarkEntity> getAdvertiseBookmarksById() {
//        return advertiseBookmarksById;
//    }
//
//    public void setAdvertiseBookmarksById(Collection<AdvertiseBookmarkEntity> advertiseBookmarksById) {
//        this.advertiseBookmarksById = advertiseBookmarksById;
//    }
//
//
//    public Collection<CarEntity> getCarsById() {
//        return carsById;
//    }
//
//    public void setCarsById(Collection<CarEntity> carsById) {
//        this.carsById = carsById;
//    }
//
//
//    public Collection<DetailBookmarkEntity> getDetailBookmarksById() {
//        return detailBookmarksById;
//    }
//
//    public void setDetailBookmarksById(Collection<DetailBookmarkEntity> detailBookmarksById) {
//        this.detailBookmarksById = detailBookmarksById;
//    }
//
//
//    public Collection<DialogEntity> getDialogsById() {
//        return dialogsById;
//    }
//
//    public void setDialogsById(Collection<DialogEntity> dialogsById) {
//        this.dialogsById = dialogsById;
//    }
//
//
//    public PhotoEntity getPhotoByPhotoId() {
//        return photoByPhotoId;
//    }
//
//    public void setPhotoByPhotoId(PhotoEntity photoByPhotoId) {
//        this.photoByPhotoId = photoByPhotoId;
//    }
//
//
//    public Collection<MechanicEntity> getMechanicsById() {
//        return mechanicsById;
//    }
//
//    public void setMechanicsById(Collection<MechanicEntity> mechanicsById) {
//        this.mechanicsById = mechanicsById;
//    }
//
//
//    public Collection<MessageEntity> getMessagesById() {
//        return messagesById;
//    }
//
//    public void setMessagesById(Collection<MessageEntity> messagesById) {
//        this.messagesById = messagesById;
//    }
//
//
//    public Collection<ServiceBookmarkEntity> getServiceBookmarksById() {
//        return serviceBookmarksById;
//    }
//
//    public void setServiceBookmarksById(Collection<ServiceBookmarkEntity> serviceBookmarksById) {
//        this.serviceBookmarksById = serviceBookmarksById;
//    }
}
