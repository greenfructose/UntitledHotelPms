package com.example.untitledhotelpms.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "rooms")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE rooms SET deleted = true WHERE id = ?")
public class Room extends BaseEntity {

    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "conjoined_with")
    private Set<Room> conjoinedWith;
    @Column(name = "vacant")
    private boolean vacant;
    @Column(name = "clean")
    private boolean clean;
    @Column(name = "under_maintenance")
    private boolean underMaintenance;

    public Room(Long id,
                Date createdDate,
                String createdBy,
                Date lastModifiedDate,
                String lastModifiedBy,
                boolean deleted,
                String roomNumber,
                String description,
                Set<Room> conjoinedWith,
                boolean vacant,
                boolean clean,
                boolean underMaintenance) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.roomNumber = roomNumber;
        this.description = description;
        this.conjoinedWith = conjoinedWith;
        this.vacant = vacant;
        this.clean = clean;
        this.underMaintenance = underMaintenance;
    }
}
