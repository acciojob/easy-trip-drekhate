package com.driver.Service;

import com.driver.Repository.AirportRepository;
import com.driver.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;

public class AirportService {
//    @Autowired
//    AirportRepository airportRepository;
    AirportRepository airportRepository = new AirportRepository();
    public void addAirport(Airport airport) {
        airportRepository.addAirport(airport);
    }

    public String getLargestAirportName() {
        return airportRepository.getLargestAirportName();
    }
}
