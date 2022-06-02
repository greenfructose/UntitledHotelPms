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
@Table(name = "rewards")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE rewards SET deleted = true WHERE id = ?")
public class Rewards extends BaseEntity {

    @Column(name="points")
    private Long points;

    @Builder
    public Rewards(Long id,
                   Date createdDate,
                   String createdBy,
                   Date lastModifiedDate,
                   String lastModifiedBy,
                   boolean deleted,
                   Long points) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.points = points;
    }
}
