package com.lcwd.irctc.Controller;

import com.lcwd.irctc.Entity.Station;
import com.lcwd.irctc.Service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    StationService stationService;

    @GetMapping
    public List<Station> getStations() {
       return stationService.getAllStations();
    }
    @GetMapping("/{code}")
    public Station getStationByCode(@PathVariable String code) {
         return stationService.getStationByCode(code);
    }
    @PostMapping
    public void addStation(@RequestBody Station station) {
        stationService.addStation(station);
    }
    @PutMapping
    public void updateStation(@RequestBody Station station) {
        stationService.updateStation(station);
    }
    @GetMapping("/search/{keyword}")
    public Station searchStation(@PathVariable String keyword) {
        return stationService.searchStation(keyword);
    }


}
