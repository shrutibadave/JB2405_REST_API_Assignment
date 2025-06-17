package com.lcwd.irctc.Controller;


import com.lcwd.irctc.Entity.Train;
import com.lcwd.irctc.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//Controller+ ResponseBody== RestController
@RequestMapping("/trains")
public class TrainController {


    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<Train> all() {
        return this.trainService.all();
    }

    @GetMapping("/{trainNo}")
    public Train get(@PathVariable("trainNo") String trainNo) {
        return this.trainService.get(trainNo);
    }


    //add train

    @PostMapping
    public ResponseEntity<Train> add(@RequestBody Train train) {
        return  new ResponseEntity<>(this.trainService.add(train), HttpStatus.CREATED);
    }


    @DeleteMapping("/{trainNo}")
    public void delete(@PathVariable String trainNo) {
        this.trainService.delete(trainNo);
    }
    @PutMapping
    public void update(@RequestBody Train train) {
        this.trainService.update(train);
    }
    @GetMapping("/search")
    public Train search(@RequestParam String name) {
        return this.trainService.findTrain(name);
    }

}
