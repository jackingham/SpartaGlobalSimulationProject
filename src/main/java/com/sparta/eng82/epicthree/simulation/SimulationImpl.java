package com.sparta.eng82.epicthree.simulation;

import com.sparta.eng82.objects.Trainee;
import com.sparta.eng82.objects.TrainingCentre;

import java.util.ArrayList;

public class SimulationImpl implements Simulation {

    static int month = 0;

    @Override
    public ArrayList<Trainee> generateTrainees(int numberOfTrainees) {
        ArrayList<Trainee> tempTrainees = new ArrayList<>();

        for (int i = 0; i < numberOfTrainees; i++) {
            tempTrainees.add(new Trainee(month));
        }

        return tempTrainees;
    }

    @Override
    public TrainingCentre generateTrainingCentre() {
        return new TrainingCentre();
    }
}
