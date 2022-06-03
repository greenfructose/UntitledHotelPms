package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "role")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE role SET deleted = true WHERE id = ?")
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
                    String name) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.name = name;
    }
}
