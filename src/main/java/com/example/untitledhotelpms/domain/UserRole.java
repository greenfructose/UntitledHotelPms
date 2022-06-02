package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE user_roles SET deleted = true WHERE id = ?")
public class UserRole extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Builder
    public UserRole(Long id,
                    Date createdDate,
                    String createdBy,
                    Date lastModifiedDate,
                    String lastModifiedBy,
                    boolean deleted,
                    String name,
                    LocalDateTime createdAt,
                    AppUser createdBy1) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
    }
}
