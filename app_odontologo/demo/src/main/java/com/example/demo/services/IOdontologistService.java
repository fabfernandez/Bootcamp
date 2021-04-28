package com.example.demo.services;

import com.example.demo.dtos.OdontologistDTO;
import com.example.demo.entities.Odontologist;
import com.example.demo.exceptions.ApiException;

import java.util.List;

public interface IOdontologistService {
    List<OdontologistDTO> getOdontologists() throws ApiException;
    OdontologistDTO saveOdontologist(OdontologistDTO odontologist)throws ApiException;
    OdontologistDTO findOdontologist(Long id)throws ApiException;
    void deleteOdontologist(Long id)throws ApiException;
}
