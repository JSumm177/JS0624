package com.example.javademo.repository;

import com.example.javademo.model.equipment.Chainsaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainsawRepository extends JpaRepository<Chainsaw, Long> {
    Chainsaw findByCode(String code);

}
