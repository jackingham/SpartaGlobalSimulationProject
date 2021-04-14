package com.sparta.eng82.controller;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import com.sparta.eng82.utilities.RandomGeneratorImpl;
import com.sparta.eng82.view.OutputManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SimulationImpl implements Simulation {

    private static final Queue<Trainee> waitingList = new LinkedList<>();
    public static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    static int month = 0;
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

    @Override
    public void startSimulation(int numberOfMonths) {
        while (month <= numberOfMonths) {
            if (month != 0) {
                waitingList.addAll(generateTrainees(randomGenerator.randomInt(20, 31)));

                if (month % 2 == 0) {
                    trainingCentres.add(generateTrainingCentre());
                }

                for (TrainingCentre centre : trainingCentres) {
                    if (centre.getTraineeArraySize() < 100) {
                        int traineeIntake = randomGenerator.randomInt(0, 21);
                        if (traineeIntake < 100 - centre.getTraineeArraySize()) {
                            for (int i = 0; i < traineeIntake; i++) {
                                centre.addTraineeToCentre(waitingList.poll());
                            }
                        } else {
                            for (int j = 0; j < 100 - centre.getTraineeArraySize(); j++) {
                                centre.addTraineeToCentre(waitingList.poll());
                            }
                        }
                    }
                }
            }

            month++;
        }
        generateOutput();
    }

    public Queue<Trainee> getWaitingList() {
        return waitingList;
    }

    public ArrayList<TrainingCentre> getTrainingCentres() {
        return trainingCentres;
    }

    public int getMonth() {
        return month;
    }

    public void generateOutput() {
        OutputManager outputManager = new OutputManager(trainingCentres, waitingList);
        outputManager.generateOutput();
    }


}
