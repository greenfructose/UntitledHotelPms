package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "reservation_request")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE reservation_request SET deleted = true WHERE id = ?")
public class ReservationRequest extends BaseEntity {

    @Column(name = "content")
    private String content;
    @ManyToOne
    private Reservation reservation;

    @Builder
    public ReservationRequest(Long id,
                              Date createdDate,
                              String createdBy,
                              Date lastModifiedDate,
                              String lastModifiedBy,
                              boolean deleted,
                              String content,
                              Reservation reservation) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.content = content;
        this.reservation = reservation;
    }
}
