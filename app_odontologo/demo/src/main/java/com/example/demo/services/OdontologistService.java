package com.example.demo.services;

import com.example.demo.dtos.OdontologistDTO;
import com.example.demo.entities.Agenda;
import com.example.demo.entities.Odontologist;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repository.IOdontologistRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OdontologistService implements IOdontologistService {

    private IOdontologistRepository repository;

    private ModelMapper mapper =  new ModelMapper();

    public OdontologistService(IOdontologistRepository repository) {
        this.repository = repository;
    }

    /**
     * Get Odontologists
     *
     * @return a Odontologist List
     */
    @Override
    @Transactional(readOnly = true)
    public List<OdontologistDTO> getOdontologists() throws ApiException {
        List<Odontologist> odontologists = this.repository.findAll();
        List<OdontologistDTO> odontologistList = mapper.map(odontologists, new TypeToken<ArrayList<OdontologistDTO>>() {}.getType());
        return odontologistList;
    }

    /**
     * Save Odontologiste
     *
     * @param odontologist OdontologistDTO
     * @return a OdontologistDTO
     * Create or Update a Odontologist
     */
    @Override
    public OdontologistDTO saveOdontologist(OdontologistDTO odontologist) throws ApiException {
        if (odontologist.getId() != null) {
            Boolean isExists = this.repository.existsById(odontologist.getId());
            if (isExists) {
                Odontologist odontologistAux = mapper.map(odontologist,Odontologist.class);
                this.repository.save(odontologistAux);
            } else {
                Odontologist odontologistAux = mapper.map(odontologist,Odontologist.class);
                this.repository.save(odontologistAux);
            }
            return odontologist;
        } else {
                Odontologist odontologistAux = mapper.map(odontologist,Odontologist.class);
                this.repository.save(odontologistAux);
            }
            return odontologist;
        }

    /**
     * Get one Odontologist by Id
     *
     * @param id Odontologist Id
     * @return a OdontologistDTO
     */
    @Override
    @Transactional(readOnly = true)
    public OdontologistDTO findOdontologist(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            Odontologist odontologistAux = this.repository.getOne(id);
            OdontologistDTO odontologist = mapper.map(odontologistAux,OdontologistDTO.class);
            return odontologist;
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Odontologist id does not Exist.");
        }
    }

    /**
     * Detele a Odontologiste by id
     *
     * @param id Odontologist Id
     */
    @Override
    public void deleteOdontologist(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            this.repository.deleteById(id);
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Odontologist id does not Exist.");
        }
    }
}
