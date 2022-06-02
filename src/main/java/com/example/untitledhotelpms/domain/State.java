package com.example.untitledhotelpms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "states")
public class State extends BaseEntity {

    private String name;
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
