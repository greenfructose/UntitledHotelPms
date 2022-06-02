package com.example.untitledhotelpms.service;

import com.example.untitledhotelpms.domain.AppUser;
import com.example.untitledhotelpms.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Getter
@Setter
@AllArgsConstructor
public class AppUserService implements CrudService<AppUser, Long> {

    private final AppUserRepository appUserRepository;

    @Override
    public Set<AppUser> findAll() {
        return new HashSet<>(appUserRepository.findAll());
    }

    @Override
    public AppUser findById(Long aLong) {
        return appUserRepository.findById(aLong).orElse(null);
    }

    @Override
    public AppUser save(AppUser object) {
        return appUserRepository.save(object);
    }

    @Override
    public void delete(AppUser object) {
        appUserRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        appUserRepository.deleteById(aLong);
    }
}
