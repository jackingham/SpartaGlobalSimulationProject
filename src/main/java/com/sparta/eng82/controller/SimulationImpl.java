package com.sparta.eng82.controller;

import com.sparta.eng82.model.*;
import com.sparta.eng82.utilities.Printer;
import com.sparta.eng82.utilities.RandomGeneratorImpl;
import com.sparta.eng82.view.OutputManager;

import java.util.*;

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

    @Override
    public ArrayList<Trainee> generateTrainees(int numberOfTrainees) {
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

//    public void generateOutput() {
//        OutputManager outputManager = new OutputManager(getTrainingCentres(), getWaitingList());
//        outputManager.summary();
//    }

    public int getMonth() {
        return month;
    }

    @Override
    public ArrayList<TrainingCentre> generateTrainingCentre() {
        ArrayList<TrainingCentre> tempCentreList = new ArrayList<>();
        while (true) {
            CentreTypes newCentreType = CentreTypes.getRandomCentreType();
            //System.out.println(newCentreType);
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
        while (month <= numberOfMonths) {
            //if(month >= 3){  //Commented this code as a change

            //}
            if (month != 0) {
                waitingList.addAll(generateTrainees(randomGenerator.randomInt(20, 31)));

                if (month % 2 == 0) {
                    trainingCentres.addAll(generateTrainingCentre());
                }

                for (TrainingCentre centre : trainingCentres) {
                    // System.out.println("1: " + centre.getClass().getTypeName());

                    if (centre.getClass().getTypeName().equals(bootcamp.getClass().getTypeName())) {
                        System.out.println("In SimulationImpl " + centre.getTraineeArraySize());
                        if(centre.getTraineeArraySize()!=Bootcamp.getMaximumCapacity()){ //changed here
                            if (centre.getTraineeArraySize() < Bootcamp.getMaximumCapacity()) {
                                int traineeIntake = randomGenerator.randomInt(0, 21);
                                System.out.println("3 Bootcamp: " + traineeIntake + " / " + (Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize()));
                                if (traineeIntake < (Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize())) {//why not <=?
                                    for (int i = 0; i < traineeIntake; i++) {
                                        centre.addTraineeToCentre(waitingList.poll());
                                    }
                                    System.out.println(centre.getTraineeArraySize());
                                }
                                else {
                                    System.out.println("4: " + traineeIntake + " / " + (Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize()));
                                    for (int j = 0; j < (Bootcamp.getMaximumCapacity() - centre.getTraineeArraySize()); j++) {
                                        centre.addTraineeToCentre(waitingList.poll());
//                                    System.out.println("5: " + j);
                                    }
                                }
                            }
                        }} else if (centre.getClass().getTypeName().equals(trainingHub.getClass().getTypeName())) {
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

                                HashMap<String, Integer> stuff =  outputManager.getNumberOfOpenCentres();

                                //System.out.println(stuff.values());
                                //System.out.println(waitingList);

                                waitingList.removeIf(Objects::isNull);

                                if(!waitingList.isEmpty()) {
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

                                    for(Trainee trainee : tempWaitingList){
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
                centreManager.closeCentre(trainingCentres);

                if (outputEveryMonth) {
                    OutputManager outputManager = new OutputManager();
                    outputManager.generateReport(this, month);
                }
            }
            month++;
        }

        for(TrainingCentre tc : trainingCentres){
            if(tc.getClass().getTypeName().equals(bootcamp.getClass().getTypeName())){
                System.out.println(tc.getClass().getTypeName());
                System.out.println(((Bootcamp)tc).isOpenStatus());
                System.out.println(tc.getTraineeArraySize());
            }
        }

        if (!outputEveryMonth) {
            OutputManager outputManager = new OutputManager();
            outputManager.generateReport(this, month);
        }
    }


    public void addDisplacedTraineesToWaitingList(ArrayList<Trainee> displacedTrainees) {
        for (Trainee trainee : displacedTrainees) {
            ((LinkedList) waitingList).addFirst(trainee);
        }
    }
}
