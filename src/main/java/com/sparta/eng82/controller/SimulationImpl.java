package com.sparta.eng82.controller;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import com.sparta.eng82.utilities.RandomGeneratorImpl;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SimulationImpl implements Simulation {

    static int month = 0;
    private static final Queue<Trainee> waitingList = new PriorityQueue<>();
    public static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    private final RandomGeneratorImpl randomGenerator = new RandomGeneratorImpl();

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

    void startSimulation(int numberOfMonths) {
        while (month <= numberOfMonths) {

            if (month != 0) {
                ArrayList<Trainee> tempTrainees = generateTrainees(randomGenerator.randomInt(20, 31));

                if (month % 2 == 0) {
                    generateTrainingCentre();
                }
                //takeInTrainees();
            }

            month++;
        }
    }

    public boolean addToWaitingList(Trainee t) {
        try {
            waitingList.add(t);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

}

