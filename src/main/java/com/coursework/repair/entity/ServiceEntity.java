package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "service", schema = "public", catalog = "postgres")
public class ServiceEntity {
    private long id;
    private String name;
    private String adressRegion;
    private String adressCity;
    private String adressStreet;
    private String adressHouse;
    private String hours;
    private Long photoId;
    private String phone;
    private Integer rating;
    private String href;
    private Collection<MechanicEntity> mechanicsById;
    private PhotoEntity photoByPhotoId;
    private Collection<ServiceBookmarkEntity> serviceBookmarksById;
    private Collection<ServiceModelsEntity> serviceModelsById;
    private String content;

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
    @Column(name = "adress_region")
    public String getAdressRegion() {
        return adressRegion;
    }

    public void setAdressRegion(String adressRegion) {
        this.adressRegion = adressRegion;
    }

    @Basic
    @Column(name = "adress_city")
    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    @Basic
    @Column(name = "adress_street")
    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    @Basic
    @Column(name = "adress_house")
    public String getAdressHouse() {
        return adressHouse;
    }

    public void setAdressHouse(String adressHouse) {
        this.adressHouse = adressHouse;
    }

    @Basic
    @Column(name = "hours")
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "photo_id")
    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(adressRegion, that.adressRegion) &&
                Objects.equals(adressCity, that.adressCity) &&
                Objects.equals(adressStreet, that.adressStreet) &&
                Objects.equals(adressHouse, that.adressHouse) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(photoId, that.photoId) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(href, that.href);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, adressRegion, adressCity, adressStreet, adressHouse, hours, photoId, phone, rating, href);
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<MechanicEntity> getMechanicsById() {
        return mechanicsById;
    }

    public void setMechanicsById(Collection<MechanicEntity> mechanicsById) {
        this.mechanicsById = mechanicsById;
    }

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", insertable = false, updatable = false)
    public PhotoEntity getPhotoByPhotoId() {
        return photoByPhotoId;
    }

    public void setPhotoByPhotoId(PhotoEntity photoByPhotoId) {
        this.photoByPhotoId = photoByPhotoId;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<ServiceBookmarkEntity> getServiceBookmarksById() {
        return serviceBookmarksById;
    }

    public void setServiceBookmarksById(Collection<ServiceBookmarkEntity> serviceBookmarksById) {
        this.serviceBookmarksById = serviceBookmarksById;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<ServiceModelsEntity> getServiceModelsById() {
        return serviceModelsById;
    }

    public void setServiceModelsById(Collection<ServiceModelsEntity> serviceModelsById) {
        this.serviceModelsById = serviceModelsById;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
