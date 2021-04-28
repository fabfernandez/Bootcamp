package com.example.demo.services;

import com.example.demo.dtos.OdontologistDTO;
import com.example.demo.entities.Agenda;
import com.example.demo.entities.Odontologist;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repository.IOdontologistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OdontologistService implements IOdontologistService {

    private IOdontologistRepository repository;

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
        List<OdontologistDTO> odontologistList = new ArrayList<>();
        for (int i = 0; i < odontologists.size(); i++) {
            OdontologistDTO odontologist = new OdontologistDTO();
            odontologist.setId(odontologists.get(i).getId());
            odontologist.setDni(odontologists.get(i).getDni());
            odontologist.setName(odontologists.get(i).getName());
            odontologist.setLastName(odontologists.get(i).getLastName());
            odontologist.setAgenda((List<Agenda>) odontologists.get(i).getAgenda());
            odontologistList.add(odontologist);
        }
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
        Boolean isExists = this.repository.existsById(odontologist.getId());
        if (isExists) {
            Odontologist odontologistAux = this.repository.getOne(odontologist.getId());
            odontologistAux.setAgenda((Set<Agenda>) odontologist.getAgenda());
            odontologistAux.setId(odontologist.getId());
            odontologist.setDni(odontologist.getDni());
            odontologistAux.setName(odontologist.getName());
            odontologistAux.setLastName(odontologist.getLastName());
            this.repository.save(odontologistAux);
        } else {
            Odontologist odontologistAux = new Odontologist();
            odontologistAux.setAgenda((Set<Agenda>) odontologist.getAgenda());
            odontologistAux.setId(odontologist.getId());
            odontologist.setDni(odontologist.getDni());
            odontologistAux.setName(odontologist.getName());
            odontologistAux.setLastName(odontologist.getLastName());
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
            OdontologistDTO odontologist = new OdontologistDTO();
            odontologist.setId(odontologistAux.getId());
            odontologist.setDni(odontologistAux.getDni());
            odontologist.setName(odontologistAux.getName());
            odontologist.setLastName(odontologistAux.getLastName());
            odontologist.setAgenda((List<Agenda>) odontologistAux.getAgenda());
            this.repository.save(odontologistAux);
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
