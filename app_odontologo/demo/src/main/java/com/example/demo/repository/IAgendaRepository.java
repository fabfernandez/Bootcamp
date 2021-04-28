package com.example.demo.repository;

import com.example.demo.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<Agenda, Long>{
}
