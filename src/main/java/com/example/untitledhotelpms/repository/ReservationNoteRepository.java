package com.example.untitledhotelpms.repository;

import com.example.untitledhotelpms.domain.ReservationNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReservationNoteRepository extends JpaRepository<ReservationNote, Long> {
}
