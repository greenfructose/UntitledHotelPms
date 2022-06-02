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
                   Set<Role> roles) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }


}
