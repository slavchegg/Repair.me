package com.coursework.repair.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detail_bookmark", schema = "public", catalog = "postgres")
public class DetailBookmarkEntity {
    private long id;
    private Long detailId;
    private Long manId;
    private DetailEntity detailByDetailId;
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
    @Column(name = "detail_id")
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
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
        DetailBookmarkEntity that = (DetailBookmarkEntity) o;
        return id == that.id &&
                Objects.equals(detailId, that.detailId) &&
                Objects.equals(manId, that.manId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, detailId, manId);
    }

    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    public DetailEntity getDetailByDetailId() {
        return detailByDetailId;
    }

    public void setDetailByDetailId(DetailEntity detailByDetailId) {
        this.detailByDetailId = detailByDetailId;
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
