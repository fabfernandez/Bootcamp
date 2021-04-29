package com.example.demo.controllers;

import com.example.demo.dtos.OdontologistDTO;
import com.example.demo.exceptions.ApiException;
import com.example.demo.services.OdontologistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class OdontologistController {
    private OdontologistService service;

    public OdontologistController(OdontologistService service) {
        this.service = service;
    }
    /**
     * Post and Patch endpoint /odontologist
     *
     * @param odontologist Odontologist dto
     * @return a ResponseEntity with the save result
     */
    @PostMapping("/odontologist")
    @PatchMapping("/odontologist")
    public ResponseEntity<OdontologistDTO> odontologist(@RequestBody OdontologistDTO odontologist) throws ApiException {
        return new ResponseEntity<OdontologistDTO>(this.service.saveOdontologist(odontologist), HttpStatus.OK);
    }
    /**
     * GET endpoint /odontologists
     *
     * @return a odontologist list
     */
    @GetMapping("/odontologists")
    public ResponseEntity<List<OdontologistDTO>> odontologists() throws ApiException {
        return new ResponseEntity<List<OdontologistDTO>>(this.service.getOdontologists(), HttpStatus.OK);
    }
    /**
     * GET endpoint /odontologist/id
     *
     * @param id the id of the odontologist
     * @return a odontologist list
     */
    @GetMapping("/odontologist/{id}")
    public ResponseEntity<OdontologistDTO> odontologist(@RequestParam Long id) throws ApiException {
        return new ResponseEntity<OdontologistDTO>(this.service.findOdontologist(id), HttpStatus.OK);
    }
    /**
     * DELETE endpoint /odontologist/id
     *
     * @param id the id of the odontologist
     */
    @DeleteMapping("/odontologist/{id}")
    public ResponseEntity deleteOdontologists(@RequestParam Long id) throws ApiException {
        this.service.deleteOdontologist(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
