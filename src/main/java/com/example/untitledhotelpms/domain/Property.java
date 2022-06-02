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
@Table(name = "property")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE property SET deleted = true WHERE id = ?")
public class Property extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    private Address address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "website")
    private String website;
    @Column(name = "email")
    private String email;

    @Builder
    public Property(Long id,
                    Date createdDate,
                    String createdBy,
                    Date lastModifiedDate,
                    String lastModifiedBy,
                    boolean deleted,
                    String name,
                    String description,
                    Address address,
                    String phone,
                    String fax,
                    String website,
                    String email) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.website = website;
        this.email = email;
    }
}
