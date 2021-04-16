package com.sparta.eng82.controller;

import com.sparta.eng82.model.*;
import com.sparta.eng82.utilities.FileOutput;
import com.sparta.eng82.utilities.Printer;
import com.sparta.eng82.utilities.RandomGeneratorImpl;
import com.sparta.eng82.view.OutputManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SimulationImpl implements Simulation {

    private static final Queue<Trainee> waitingList = new LinkedList<>();
    public static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    static int month = 0;
    private final RandomGeneratorImpl randomGenerator = new RandomGeneratorImpl();
    private final TechCentre techCentre = new TechCentre();
    private final Bootcamp bootcamp = new Bootcamp();
    private final TrainingHub trainingHub = new TrainingHub();
    private final CentreManager centreManager = new CentreManager();
    private final OutputManager outputManager = new OutputManager();
    private final FileOutput fileOutput = new FileOutput();

    @Override
    public ArrayList<Trainee> generateTrainees(Integer numberOfTrainees) {
        ArrayList<Trainee> tempTrainees = new ArrayList<>();

        for (int i = 0; i < numberOfTrainees; i++) {
            tempTrainees.add(new Trainee(month));
        }

        return tempTrainees;
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


    @Override
    public ArrayList<TrainingCentre> generateTrainingCentre() {
        ArrayList<TrainingCentre> tempCentreList = new ArrayList<>();
        while (true) {
            CentreTypes newCentreType = CentreTypes.getRandomCentreType();
            switch (newCentreType) {
                case BOOTCAMP:
                    if (Bootcamp.getLifetimeNumberOfBootcamps() < 2) {
                        Bootcamp.incrementLifetimeNumberOfBootcamps();
                        tempCentreList.add(new Bootcamp());
                        return tempCentreList;
                    }
                case TECH_CENTRE:
                    tempCentreList.add(new TechCentre());
                    return tempCentreList;
                case TRAINING_HUB:
                    for (int i = 0; i < 3; i++) {
                        tempCentreList.add(new TrainingHub());
                    }
                    return tempCentreList;
                default:
                    return null;
            }

        }
    }

    @Override
    public void startSimulation(int numberOfMonths, boolean outputEveryMonth) {
        fileOutput.clearFile();
        while (month <= numberOfMonths) {
            if (month >= 3) {
                centreManager.closeCentre(trainingCentres);
            }
            if (month != 0) {
                waitingList.addAll(generateTrainees(randomGenerator.randomInt(20, 31)));

                if (month % 2 == 0) {
                    trainingCentres.addAll(generateTrainingCentre());
                }

                for (TrainingCentre centre : trainingCentres) {
                    if (centre.getClass().getTypeName().equals(bootcamp.getClass().getTypeName())) {
                        if (centre.getTraineeArraySize() < Bootcamp.getMaximumCapacity()) {
                            int traineeIntake = randomGenerator.randomInt(0, 21);
                            if (traineeIntake < Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize()) {
                                for (int i = 0; i < traineeIntake; i++) {
                                    centre.addTraineeToCentre(waitingList.poll());
                                }
                            } else {
                                for (int j = 0; j < Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize(); j++) {
                                    centre.addTraineeToCentre(waitingList.poll());
                                }
                            }
                        }
                    } else if (centre.getClass().getTypeName().equals(trainingHub.getClass().getTypeName())) {
                        if (centre.getTraineeArraySize() < TrainingHub.getMaximumCapacity()) {
                            int traineeIntake = randomGenerator.randomInt(0, 21);
                            if (traineeIntake < TrainingHub.getMaximumCapacity() - centre.getTraineeArraySize()) {
                                for (int i = 0; i < traineeIntake; i++) {
                                    centre.addTraineeToCentre(waitingList.poll());
                                }
                            } else {
                                for (int j = 0; j < TrainingHub.getMaximumCapacity() - centre.getTraineeArraySize(); j++) {
                                    centre.addTraineeToCentre(waitingList.poll());
                                }
                            }
                        }
                    } else if (centre.getClass().getTypeName().equals(techCentre.getClass().getTypeName())) {
                        if (!techCentre.full()) {
                            int traineeIntake = randomGenerator.randomInt(0, 21);
                            if (traineeIntake > 0) {
                                CourseTypes courseTypes = techCentre.getCentreCourseName();
                                int i = 0;
                                int j = 0;

                                Queue<Trainee> tempWaitingList = new LinkedList<>();


                                waitingList.removeIf(Objects::isNull);

                                if (!waitingList.isEmpty()) {
                                    while (i < traineeIntake && j < waitingList.size()) {
                                        for (Trainee trainee : waitingList) {
                                            if (trainee.getCourseName().equals(courseTypes)) {
                                                tempWaitingList.add(trainee);
                                                i++;
                                            }
                                            if (i == traineeIntake) {
                                                break;
                                            }
                                        }
                                        j++;
                                    }
                                    //TODO - Think about this, could be computationally expensive, is there a better way to break the while loop?

                                    for (Trainee trainee : tempWaitingList) {
                                        centre.addTraineeToCentre(trainee);
                                    }
                                    waitingList.removeAll(tempWaitingList);
                                }
                            }
                        }
                    } else {
                        Printer.printMessage("Error centre type unknown");
                    }
                }

                if (outputEveryMonth) {
                    outputManager.generateReport(this, month);
                }
            }
            month++;
        }


        if (!outputEveryMonth) {
            outputManager.generateReport(this, month);
        }
    }


    public void addDisplacedTraineesToWaitingList(ArrayList<Trainee> displacedTrainees) {
        for (Trainee trainee : displacedTrainees) {
            ((LinkedList) waitingList).addFirst(trainee);
        }
    }
}
