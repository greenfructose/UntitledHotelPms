package com.example.untitledhotelpms.repository;

import com.example.untitledhotelpms.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
