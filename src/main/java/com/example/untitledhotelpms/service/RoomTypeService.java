package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.RoomType;
import com.example.untitledhotelpms.repository.RoomRepository;
import com.example.untitledhotelpms.repository.RoomTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoomTypeService implements CrudService<RoomType, Long> {

    private final RoomTypeRepository roomTypeRepository;
    @Override
    public Set<RoomType> findAll() {
        return new HashSet<>(roomTypeRepository.findAll());
    }

    @Override
    public RoomType findById(Long aLong) {
        return roomTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public RoomType save(RoomType object) {
        return roomTypeRepository.save(object);
    }

    @Override
    public void delete(RoomType object) {
        roomTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        roomTypeRepository.deleteById(aLong);
    }
}
