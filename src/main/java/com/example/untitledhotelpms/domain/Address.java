package com.example.untitledhotelpms.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(name = "street_1")
    private String street1;
    @Column(name = "street_2")
    private String street2;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "state")
    private State state;

    @Builder
    public Address(Long id,
                   Date createdDate,
                   String createdBy,
                   Date lastModifiedDate,
                   String lastModifiedBy,
                   boolean deleted,
                   String street1,
                   String street2,
                   String postalCode,
                   State state) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.street1 = street1;
        this.street2 = street2;
        this.postalCode = postalCode;
        this.state = state;
    }
}
