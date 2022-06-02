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
@Table(name = "amenity")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE amenity SET deleted = true WHERE id = ?")
public class Amenity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "hours")
    private String hours;

    @Builder
    public Amenity(Long id,
                   Date createdDate,
                   String createdBy,
                   Date lastModifiedDate,
                   String lastModifiedBy,
                   boolean deleted,
                   String name,
                   String description,
                   String hours) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
        this.description = description;
        this.hours = hours;
    }
}
