package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "room_type")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE room_type SET deleted = true WHERE id = ?")
public class RoomType extends BaseEntity {

    @Column(name ="name")
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name ="king_beds")
    private Long kingBeds;
    @Column(name ="queen_beds")
    private Long queenBeds;
    @Column(name ="full_beds")
    private Long fullBeds;
    @Column(name ="twin_beds")
    private Long twinBeds;
    @Column(name ="infant_beds")
    private Long infantBeds;
    @Column(name ="sofa_beds")
    private Long sofaBeds;
    @Column(name ="has_fridge")
    private boolean hasFridge;
    @Column(name ="has_microwave")
    private boolean hasMicrowave;
    @Column(name ="has_kitchenette")
    private boolean hasKitchenette;
    @Column(name ="handicap_accessible")
    private boolean handicapAccessible;
    @Column(name ="smoking")
    private boolean smoking;

    @Builder
    public RoomType(Long id,
                    Date createdDate,
                    String createdBy,
                    Date lastModifiedDate,
                    String lastModifiedBy,
                    boolean deleted,
                    String name,
                    String description,
                    Long kingBeds,
                    Long queenBeds,
                    Long fullBeds,
                    Long twinBeds,
                    Long infantBeds,
                    Long sofaBeds,
                    boolean hasFridge,
                    boolean hasMicrowave,
                    boolean hasKitchenette,
                    boolean handicapAccessible,
                    boolean smoking) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
        this.description = description;
        this.kingBeds = kingBeds;
        this.queenBeds = queenBeds;
        this.fullBeds = fullBeds;
        this.twinBeds = twinBeds;
        this.infantBeds = infantBeds;
        this.sofaBeds = sofaBeds;
        this.hasFridge = hasFridge;
        this.hasMicrowave = hasMicrowave;
        this.hasKitchenette = hasKitchenette;
        this.handicapAccessible = handicapAccessible;
        this.smoking = smoking;
    }
}
