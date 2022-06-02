package com.example.untitledhotelpms.repository;

import com.example.untitledhotelpms.domain.ReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {
}
