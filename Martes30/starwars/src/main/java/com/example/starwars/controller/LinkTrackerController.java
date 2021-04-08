package com.example.starwars.controller;

import com.example.starwars.dto.LinkIdDTO;
import com.example.starwars.service.LinkTrackerServiceUuidImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@RestController
@RequestMapping("/link")
public class LinkTrackerController {

    private final LinkTrackerServiceUuidImplementation linkTrackerServiceUuidImplementation;

    @Autowired
    public LinkTrackerController(LinkTrackerServiceUuidImplementation linkTrackerServiceUuidImplementation) {
        this.linkTrackerServiceUuidImplementation = linkTrackerServiceUuidImplementation;
    }

    @PostMapping("/create")
    public ResponseEntity<LinkIdDTO> createLink(@RequestParam(value = "url") URL url) {

        return new ResponseEntity<>(
                linkTrackerServiceUuidImplementation.createLinkId(url),
                HttpStatus.OK);
    }


}
