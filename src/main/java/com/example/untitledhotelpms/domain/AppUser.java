package com.example.untitledhotelpms.domain;

import lombok.*;
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
@Table(name = "app_user")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE app_user SET deleted = true WHERE id = ?")
public class AppUser extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "postal_code")
    private String postalCode;
    @OneToOne
    private Rewards rewards;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "app_user_roles",
    joinColumns = {
            @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    private Set<Role> roles = new HashSet<>();


    @Builder
    public AppUser(Long id,
                   Date createdDate,
                   String createdBy,
                   Date lastModifiedDate,
                   String lastModifiedBy,
                   boolean deleted,
                   String firstName,
                   String lastName,
                   String email,
                   String phone,
                   String address1,
                   String address2,
                   String city,
                   String state,
                   String country,
                   String postalCode,
                   Rewards rewards,
                   Set<Role> roles) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.rewards = rewards;
        this.roles = roles;
    }
}
