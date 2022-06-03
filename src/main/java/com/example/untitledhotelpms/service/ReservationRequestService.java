package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.ReservationRequest;
import com.example.untitledhotelpms.repository.ReservationRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationRequestService implements CrudService<ReservationRequest, Long> {

    private final ReservationRequestRepository reservationRequestRepository;
    @Override
    public Set<ReservationRequest> findAll() {
        return new HashSet<>(reservationRequestRepository.findAll());
    }

    @Override
    public ReservationRequest findById(Long aLong) {
        return reservationRequestRepository.findById(aLong).orElse(null);
    }

    @Override
    public ReservationRequest save(ReservationRequest object) {
        return reservationRequestRepository.save(object);
    }

    @Override
    public void delete(ReservationRequest object) {
        reservationRequestRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reservationRequestRepository.deleteById(aLong);
    }
}
