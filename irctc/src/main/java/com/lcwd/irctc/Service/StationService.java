package com.lcwd.irctc.Service;

import com.lcwd.irctc.Entity.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {
    List<Station> stations =new ArrayList<>();

    public StationService() {
        stations.add(new Station("LKO", "Lucknow"));
        stations.add(new Station("DEL", "Delhi"));
        stations.add(new Station("BAN", "Banaras"));
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }
    public Station getStationByCode(String code)
    {
        return stations.stream().filter(station -> station.getStationCode().equals(code)).findFirst().get();
    }
    public List<Station> getAllStations()
    {
        return stations;
    }

    public void updateStation(Station station)
    {
       Station s= getStationByCode(station.getStationCode());
       s.setStationName(station.getStationName());

    }
    public void deleteStation(String code)
    {
            stations.remove(getStationByCode(code));
    }
    public Station searchStation(String keyword) {
       return stations.stream().filter(station -> station.getStationName().toLowerCase().contains(keyword.toLowerCase())).findFirst().get();
    }
}
