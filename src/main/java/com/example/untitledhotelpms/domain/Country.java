package com.example.untitledhotelpms.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Builder
    public Country(Long id,
                   Date createdDate,
                   String createdBy,
                   Date lastModifiedDate,
                   String lastModifiedBy,
                   boolean deleted,
                   String name) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
    }
}
