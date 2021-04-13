package com.example.starwars.service;

import com.example.starwars.dto.LinkIdDTO;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.UUID;

@Service
public class LinkTrackerServiceUuidImplementation implements LinkTrackerService{

    public LinkIdDTO createLinkId(URL url) {

        //Todo: Get the repository implementation to save the URL and the designed ID.

        String linkId = UUID.randomUUID().toString();

        return new LinkIdDTO(linkId);
    }
}
