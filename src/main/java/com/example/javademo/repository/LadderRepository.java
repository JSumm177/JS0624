package com.example.javademo.repository;

import com.example.javademo.model.equipment.Ladder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LadderRepository extends JpaRepository<Ladder, Long> {
    Ladder findByCode(String ladw);
}
