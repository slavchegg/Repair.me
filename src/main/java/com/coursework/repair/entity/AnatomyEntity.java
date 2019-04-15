package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "anatomy", schema = "public", catalog = "postgres")
public class AnatomyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Basic
//    @Column(name = "engine_id")
//    private Long engineId;
//    @Basic
//    @Column(name = "gearbox_id")
//    private Long gearboxId;
//    @Basic
//    @Column(name = "suspension_id")
//    private Long suspensionId;
//    private Long electronicId;
//    private Long lightsId;
//    private Long wheelsId;
//    private Long brakesId;
//    private Long enteriorId;
//    private Long bodyId;

    @ManyToOne
    @JoinColumn(name = "engine_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EngineEntity engineByEngineId;

    @ManyToOne
    @JoinColumn(name = "gearbox_id", referencedColumnName = "id", insertable = false, updatable = false)
    private GearboxEntity gearboxByGearboxId;

    @ManyToOne
    @JoinColumn(name = "suspension_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SuspensionEntity suspensionBySuspensionId;

    @ManyToOne
    @JoinColumn(name = "electronic_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ElectronicEntity electronicByElectronicId;

    @ManyToOne
    @JoinColumn(name = "lights_id", referencedColumnName = "id", insertable = false, updatable = false)
    private LightsEntity lightsByLightsId;

    @ManyToOne
    @JoinColumn(name = "wheels_id", referencedColumnName = "id", insertable = false, updatable = false)
    private WheelsEntity wheelsByWheelsId;

    @ManyToOne
    @JoinColumn(name = "brakes_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BrakesEntity brakesByBrakesId;

    @ManyToOne
    @JoinColumn(name = "enterior_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EnteriorEntity enteriorByEnteriorId;

    @ManyToOne
    @JoinColumn(name = "body_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BodyEntity bodyByBodyId;

    @OneToMany(mappedBy = "anatomyByAnatomyId")
    private Collection<CarModificationEntity> carModificationsById;

}