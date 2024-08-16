package com.example.javademo.repository;

import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JackhammerRepository extends JpaRepository<Jackhammer, Long> {
    Jackhammer findByCode(String codes);
}
