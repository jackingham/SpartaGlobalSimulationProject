package com.sparta.eng82.epicthree.simulation;

import com.sparta.eng82.objects.Trainee;
import com.sparta.eng82.objects.TrainingCentre;

import java.util.ArrayList;

public interface Simulation {

    ArrayList<Trainee> generateTrainees(int numberOfTrainees);

    TrainingCentre generateTrainingCentre();
}
