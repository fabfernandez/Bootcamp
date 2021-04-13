package com.example.starwars.service;

import com.example.starwars.dto.LinkIdDTO;

import java.net.URL;

public interface LinkTrackerService {

    public LinkIdDTO createLinkId(URL url);
}
