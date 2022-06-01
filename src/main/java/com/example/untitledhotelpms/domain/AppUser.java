package com.example.untitledhotelpms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @OneToMany
    @JoinColumn(name = "user_roles_id")
    private Set<UserRole> userRoles;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public AppUser(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String phone,
                   LocalDateTime createdAt) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }
}
