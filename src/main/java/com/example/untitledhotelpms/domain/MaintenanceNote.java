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
@Table(name = "maintenance_note")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE maintenance_note SET deleted = true WHERE id = ?")
public class MaintenanceNote extends BaseEntity{

    @Column(name = "content")
    private String content;
    @ManyToOne
    private MaintenanceTicket maintenanceTicket;

    @Builder
    public MaintenanceNote(Long id,
                           Date createdDate,
                           String createdBy,
                           Date lastModifiedDate,
                           String lastModifiedBy,
                           boolean deleted,
                           String content,
                           MaintenanceTicket maintenanceTicket) {
        super(id, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleted);
        this.content = content;
        this.maintenanceTicket = maintenanceTicket;
    }
}
