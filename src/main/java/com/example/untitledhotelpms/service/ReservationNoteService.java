package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.Reservation;
import com.example.untitledhotelpms.domain.ReservationNote;
import com.example.untitledhotelpms.repository.ReservationNoteRepository;
import com.example.untitledhotelpms.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationNoteService implements CrudService<ReservationNote, Long> {

    private final ReservationNoteRepository reservationNoteRepository;
    @Override
    public Set<ReservationNote> findAll() {
        return new HashSet<>(reservationNoteRepository.findAll());
    }

    @Override
    public ReservationNote findById(Long aLong) {
        return reservationNoteRepository.findById(aLong).orElse(null);
    }

    @Override
    public ReservationNote save(ReservationNote object) {
        return reservationNoteRepository.save(object);
    }

    @Override
    public void delete(ReservationNote object) {
        reservationNoteRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reservationNoteRepository.deleteById(aLong);
    }
}
