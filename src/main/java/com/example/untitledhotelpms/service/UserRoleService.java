package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.UserRole;
import com.example.untitledhotelpms.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserRoleService implements CrudService<UserRole, Long> {

    private final UserRoleRepository userRoleRepository;

    @Override
    public Set<UserRole> findAll() {
        return new HashSet<>(userRoleRepository.findAll());
    }

    @Override
    public UserRole findById(Long aLong) {
        return userRoleRepository.findById(aLong).orElse(null);
    }

    @Override
    public UserRole save(UserRole object) {
        return userRoleRepository.save(object);
    }

    @Override
    public void delete(UserRole object) {
        userRoleRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRoleRepository.deleteById(aLong);
    }
}
