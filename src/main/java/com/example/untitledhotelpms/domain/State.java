package com.example.untitledhotelpms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "states")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE states SET deleted = true WHERE id = ?")
public class State extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToOne
    @Column(name = "country")
    private Country country;

    public State(Long id,
                 Date createdDate,
                 String createdBy,
                 Date lastModifiedDate,
                 String lastModifiedBy,
                 boolean deleted,
                 String name,
                 Country country) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
        this.country = country;
    }
}
