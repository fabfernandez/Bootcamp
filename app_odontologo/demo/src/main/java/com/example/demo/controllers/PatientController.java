package com.example.demo.controllers;

import com.example.demo.entities.Patient;
import com.example.demo.services.IPatientService;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    IPatientService iPatientService;

    @PostMapping("save")
    private String savePatient(@RequestBody Patient patient){
      String message = iPatientService.savePatient(patient);
      return message;
    }

    @GetMapping("/find/{id}")
    private Patient findPatient(@PathVariable Long id){
        return iPatientService.findPatient(id);
    }

    @PatchMapping("/update/{id}")
    private String update1(@PathVariable Long id, @RequestParam String name, @RequestParam String lastName){
        Patient patient = iPatientService.findPatient(id);
        patient.setName(name);
        patient.setLastName(lastName);
        iPatientService.savePatient(patient);
        return "Acutalizó patient por el metodo update 1";
    }

    @PutMapping("/update")
    private String update2(@RequestBody Patient patient){
        iPatientService.savePatient(patient);
        return "Acutalizó patient por el metodo update 2";
    }

    @GetMapping("/all")
    private List<Patient> getPatient(){
        return iPatientService.getPatients();
    }

    @DeleteMapping("/dalete/{id}")
    private String deletePatient(@PathVariable Long id){
        iPatientService.deletePatient(id);
        return "Eliminó el patient";
    }
}
