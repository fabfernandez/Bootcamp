package com.example.clase2spring.controller;

import com.example.clase2spring.dto.AlumnoDTO;
import com.example.clase2spring.service.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class DiplomaController{
        @PostMapping("/diploma")
        public ResponseEntity tramitarDiploma(@RequestBody AlumnoDTO alumno) {

            return new ResponseEntity(DiplomaService.getDiploma(alumno), HttpStatus.OK);

        }
}
