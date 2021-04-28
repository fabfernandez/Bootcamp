package com.example.demo.services;

import com.example.demo.entities.Patient;
import com.example.demo.repository.IPatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService{

    public final IPatientRepository patientRepository;

    public PatientService(IPatientRepository studentRepository){
        this.patientRepository = studentRepository;
    }

    @Override
    @Transactional
    public String savePatient(Patient patient){


        List<Patient> lista =  getPatients();
        lista = lista.stream().filter(patient1 -> patient1.getDni().equals(patient.getDni())).collect(Collectors.toList());
        if(lista.isEmpty()) {
            patientRepository.save(patient);
        }else{
            return "This pacient Exist";
        }

        return "Patient safe Success";

    }

    @Override
    @Transactional
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findPatient(Long id){
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }
}
