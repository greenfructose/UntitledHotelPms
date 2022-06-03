package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "room")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE room SET deleted = true WHERE id = ?")
public class Room extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToOne
    private RoomType roomType;
    @Column(name = "description")
    private String description;
    @ManyToMany
    private Set<Room> conjoinedWith = new HashSet<>();
    @Column(name = "vacant")
    private boolean vacant;
    @Column(name = "clean")
    private boolean clean;
    @Column(name = "under_maintenance")
    private boolean underMaintenance;

    @Builder
    public Room(Long id,
                Date createdDate,
                String createdBy,
                Date lastModifiedDate,
                String lastModifiedBy,
                boolean deleted,
                String name,
                String description,
                Set<Room> conjoinedWith,
                boolean vacant,
                boolean clean,
                boolean underMaintenance) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
        this.description = description;
        this.conjoinedWith = conjoinedWith;
        this.vacant = vacant;
        this.clean = clean;
        this.underMaintenance = underMaintenance;
    }
}
