package com.lcwd.irctc.Service;



import com.lcwd.irctc.Entity.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    List<Train> trainList = new ArrayList<>();

    public TrainService() {
        trainList.add(new Train("1234", "LKO-DELHI Intercity", 10));
        trainList.add(new Train("1235", "LKO-Banaras Intercity", 12));
    }


    //add train
    public Train add(Train train) {
        trainList.add(train);
        //db mein save karn ka logic
        return train;
    }

    //get all
    public List<Train> all() {
        return this.trainList;
        //db se data fetch karne ka logic
    }

    //get single
    public Train get(String trainNo) {
        Train train1 =
                trainList.stream().filter(train -> train.getTainNo().equals(trainNo))
                        .findFirst().get();
        return train1;

    }

    //delete
    public void delete(String trainNo) {
        List<Train> list = this.trainList.stream().filter(train -> !train.getTainNo().equals(trainNo)).toList();
        this.trainList = list;
    }

    public void update(Train train) {
        Train train1 = get(train.getTainNo());
        train1.setName(train.getName());
        train1.setCoches(train.getCoches());
    }
    public Train findTrain(String name) {
        Train train1 = trainList.stream().filter(train -> (train.getName().equals(name) ||
                        train.getCoches() == Integer.parseInt(name) || train.getTainNo().equals(name))).findFirst().get();
        System.out.println(train1);
        return train1;
    }
}