package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.Room;
import com.example.untitledhotelpms.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoomService implements CrudService<Room, Long> {

    private final RoomRepository roomRepository;

    @Override
    public Set<Room> findAll() {
        return new HashSet<>(roomRepository.findAll());
    }

    @Override
    public Room findById(Long aLong) {
        return roomRepository.findById(aLong).orElse(null);
    }

    @Override
    public Room save(Room object) {
        return roomRepository.save(object);
    }

    @Override
    public void delete(Room object) {
        roomRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        roomRepository.deleteById(aLong);
    }
}
