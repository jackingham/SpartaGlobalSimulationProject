package com.sparta.eng82.controller;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;

import java.util.ArrayList;

public interface Simulation {

    ArrayList<Trainee> generateTrainees(Integer numberOfTrainees);

    ArrayList<TrainingCentre> generateTrainingCentre();

    void startSimulation(Integer numberOfMonths, boolean outputEveryMonth);
}
