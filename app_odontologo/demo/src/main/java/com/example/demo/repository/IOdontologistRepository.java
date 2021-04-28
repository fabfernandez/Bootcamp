package com.example.demo.repository;

import com.example.demo.entities.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologistRepository extends JpaRepository<Odontologist,Long> {
}
