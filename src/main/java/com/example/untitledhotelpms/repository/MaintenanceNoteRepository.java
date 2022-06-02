package com.example.untitledhotelpms.repository;

import com.example.untitledhotelpms.domain.MaintenanceNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MaintenanceNoteRepository extends JpaRepository<MaintenanceNote, Long> {
}
