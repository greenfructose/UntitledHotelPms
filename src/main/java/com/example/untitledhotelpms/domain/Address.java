package com.example.untitledhotelpms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(name = "street_1")
    private String street1;
    @Column(name = "street_2")
    private String street2;
    @Column(name = "postal_code")
    private String postalCode;

    public Address(Long id, String street1, String street2, String postalCode) {
        super(id);
        this.street1 = street1;
        this.street2 = street2;
        this.postalCode = postalCode;
    }
}
