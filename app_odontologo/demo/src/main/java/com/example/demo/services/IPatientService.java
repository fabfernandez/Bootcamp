package com.example.demo.services;

import com.example.demo.entities.Patient;

import java.util.List;

public interface IPatientService {
    String savePatient(Patient student);

    void deletePatient(Long id);

    Patient findPatient(Long id);

    List<Patient> getPatients();

}
