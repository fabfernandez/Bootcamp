package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelDTO> process(Map<String, String> allParams) throws IOException {

        //decide what to do with received parameters
        //listAll or filter
        List<HotelDTO> output = hotelRepository.loadHotels();

        if (allParams.containsKey("dateFrom") &&
                allParams.containsKey("dateTo") &&
                allParams.containsKey("city") &&
                allParams.size() == 3
        ) {
            for (Map.Entry<String, String> param : allParams.entrySet()) {
                output = filter(output, param.getKey(), param.getValue());
            }
        }
        //if allParams.size() != 0 throw new BadRequestException()
        return output;
    }

    private List<HotelDTO> filter(List<HotelDTO> hotels, String key, String value) {
        return hotels.stream().filter(article -> {
            try {
                Method method = article.getClass().getMethod("get" + StringUtils.capitalize(key));
                //return true if the value equals the method call
                return method.invoke(article).equals(value);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }).collect(Collectors.toList());
    }
}
