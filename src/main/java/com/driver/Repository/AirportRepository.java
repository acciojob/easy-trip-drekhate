package com.driver.Repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AirportRepository {
    private final Map<String, Airport> airPortDB = new HashMap<>();
    private final Map<Integer, Flight> flightDB = new HashMap<>();
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

    public double getShortestDurationOfPossibleBetweenTwoCities(City fromCity, City toCity) {
        double duration = -1;
        for (Flight value: flightDB.values()) {
            if(fromCity.equals(value.getFromCity()) && toCity.equals(value.getToCity())) {
                if(duration == -1) {
                    duration = Double.MAX_VALUE;
                }
                if(value.getDuration() < duration) {
                    duration = value.getDuration();
                }
            }
        }
        return duration;
    }

    public void addFlight(Flight flight) {
        flightDB.put(flight.getFlightId(), flight);
    }

    public int getNumberOfPeopleOn(Date date, String airportName) {
        int count = 0;
        Airport airportNameObj = airPortDB.get(airportName);
        City airportNameCity = airportNameObj.getCity();
        for (Flight value: flightDB.values()) {
            if(date.equals(value.getFlightDate()) && (airportNameCity.equals(value.getFromCity()) || airportNameCity.equals(value.getToCity()))) {
                count ++;
            }
        }
        return count;
    }
}
