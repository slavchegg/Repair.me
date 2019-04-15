package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "detail", schema = "public", catalog = "postgres")
public class DetailEntity {
    private long id;
    private String node;
    private String name;
    private Collection<AdvertiseEntity> advertisesById;
    private Collection<DetailBookmarkEntity> detailBookmarksById;
    private Collection<DetailModificationEntity> detailModificationsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailEntity that = (DetailEntity) o;
        return id == that.id &&
                Objects.equals(node, that.node) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, node, name);
    }

    @OneToMany(mappedBy = "detailByDetailId")
    public Collection<AdvertiseEntity> getAdvertisesById() {
        return advertisesById;
    }

    public void setAdvertisesById(Collection<AdvertiseEntity> advertisesById) {
        this.advertisesById = advertisesById;
    }

    @OneToMany(mappedBy = "detailByDetailId")
    public Collection<DetailBookmarkEntity> getDetailBookmarksById() {
        return detailBookmarksById;
    }

    public void setDetailBookmarksById(Collection<DetailBookmarkEntity> detailBookmarksById) {
        this.detailBookmarksById = detailBookmarksById;
    }

    @OneToMany(mappedBy = "detailByDetailId")
    public Collection<DetailModificationEntity> getDetailModificationsById() {
        return detailModificationsById;
    }

    public void setDetailModificationsById(Collection<DetailModificationEntity> detailModificationsById) {
        this.detailModificationsById = detailModificationsById;
    }
}
