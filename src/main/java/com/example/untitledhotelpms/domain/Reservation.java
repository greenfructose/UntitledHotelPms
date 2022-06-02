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
@Table(name = "reservation")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE reservation SET deleted = true WHERE id = ?")
public class Reservation extends BaseEntity {

    @Column(name = "check_in")
    private Date checkIn;
    @Column(name = "check_out")
    private Date checkOut;
    @ManyToOne
    private RoomType roomType;
    @ManyToOne
    private Room room;
    @OneToOne
    private AppUser guest;
    @Column(name = "adults")
    private Long adults;
    @Column(name = "children")
    private Long children;
    @OneToMany
    private Set<ReservationRequest> reservationRequests = new HashSet<>();
    @OneToMany
    private Set<ReservationNote> reservationNotes = new HashSet<>();

    @Builder
    public Reservation(Long id,
                       Date createdDate,
                       String createdBy,
                       Date lastModifiedDate,
                       String lastModifiedBy,
                       boolean deleted,
                       Date checkIn,
                       Date checkOut,
                       RoomType roomType,
                       Room room,
                       AppUser guest,
                       Long adults,
                       Long children) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.room = room;
        this.guest = guest;
        this.adults = adults;
        this.children = children;
    }
}
