package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.Reservation;
import com.example.untitledhotelpms.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements CrudService<Reservation, Long> {

    private final ReservationRepository reservationRepository;
    @Override
    public Set<Reservation> findAll() {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public Reservation findById(Long aLong) {
        return reservationRepository.findById(aLong).orElse(null);
    }

    @Override
    public Reservation save(Reservation object) {
        return reservationRepository.save(object);
    }

    @Override
    public void delete(Reservation object) {
        reservationRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reservationRepository.deleteById(aLong);
    }
}
