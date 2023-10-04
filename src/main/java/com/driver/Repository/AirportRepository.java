package com.driver.Repository;

import com.driver.model.Airport;

import java.util.HashMap;
import java.util.Map;

public class AirportRepository {
    private final Map<String, Airport> airPortDB = new HashMap<>();
    public void addAirport(Airport airport) {
        airPortDB.put(airport.getAirportName(), airport);
    }

    public String getLargestAirportName() {
        int noOfTerminalsMax = 0;
        String getLargestAirportNameByTerminal = null;
        for (Airport value: airPortDB.values()) {
            if(noOfTerminalsMax <= value.getNoOfTerminals()) {
                if(noOfTerminalsMax == value.getNoOfTerminals()) {
//                    Lexicographically smallest airportName
                    int result = getLargestAirportNameByTerminal.compareTo(value.getAirportName());
                    if (result > 0) {
                        getLargestAirportNameByTerminal = value.getAirportName();
                    }
                    continue;
                }
                noOfTerminalsMax = value.getNoOfTerminals();
                getLargestAirportNameByTerminal = value.getAirportName();
            }
        }
        return getLargestAirportNameByTerminal;
    }
}
