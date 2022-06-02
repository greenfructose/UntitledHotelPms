package com.example.untitledhotelpms.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "maintenance_ticket")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE maintenance_ticket SET deleted = true WHERE id = ?")
public class MaintenanceTicket extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Builder

    public MaintenanceTicket(Long id,
                             Date createdDate,
                             String createdBy,
                             Date lastModifiedDate,
                             String lastModifiedBy,
                             boolean deleted,
                             String description) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.description = description;
    }
}
