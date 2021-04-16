package com.sparta.eng82.controller;

import com.sparta.eng82.model.*;

import java.util.ArrayList;
import java.util.List;

public class CentreManager {

    static ArrayList<Trainee> displacedTrainees = new ArrayList<>();

    public void closeCentre(List<TrainingCentre> centres) {
        TrainingCentre centreWithSpace = null; // a centre with space ready to take in displaced trainees

        for (TrainingCentre centre : centres) { // Looping though all centres
            int numberOfTrainees = centre.getTraineeArraySize(); //getting the number of trainees in the current centre
            if (numberOfTrainees <= 10) { // checking if the number of trainees is less than 10
                if (centre.getClass().getTypeName().equals("com.sparta.eng82.model.Bootcamp")) { // checks if the current centre is a bootcamp
                    if (((Bootcamp) centre).getNumberOfMonthsBelowRequiredAttendance() == 2) { // checks if bootcamp has been active with low attendance for 3 months
                        displacedTrainees.addAll(centre.getTraineeArray()); // if true, removes students and adds them to an internal waiting list
                        centre.removeAllTrainees();
                        centre.setFunctionStatus(false); // closes the centre
                    } else {
                        ((Bootcamp) centre).incrementNumberOfMonthsBelowRequiredAttendance(); // if less than 3 months of low attendance, increments by one month
                    }
                } else {
                    displacedTrainees.addAll(centre.getTraineeArray()); // if not bootcamp remove students and add to internal waiting list
                    centre.removeAllTrainees();
                    centre.setFunctionStatus(false); // closes the centre
                }
            } else {
                centreWithSpace = centre;
                if (centreWithSpace.getClass().getTypeName().equals("com.sparta.eng82.model.TechCentre")) { // if the current "centre with space" is a TechCentre
                    if (!((TechCentre) centreWithSpace).full()) {
                        if ((TechCentre.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()) >= displacedTrainees.size()) {
                            for (int i = 0; i < displacedTrainees.size(); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        } else {
                            for (int i = 0; i < (TechCentre.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        }
                    }
                } else if (centreWithSpace.getClass().getTypeName().equals("com.sparta.eng82.model.TrainingHub")) {
                    if (!((TrainingHub) centreWithSpace).full()) {
                        if ((TrainingHub.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()) >= displacedTrainees.size()) {
                            for (int i = 0; i < displacedTrainees.size(); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        } else {
                            for (int i = 0; i < (TrainingHub.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        }
                    }
                } else if (centreWithSpace.getClass().getTypeName().equals("com.sparta.eng82.model.Bootcamp")) {
                    ((Bootcamp) centreWithSpace).resetNumberOfMonthsBelowRequiredAttendance();//I want to comment
                    if (!((Bootcamp) centreWithSpace).full()) {
                        if ((Bootcamp.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()) >= displacedTrainees.size()) {
                            for (int i = 0; i < displacedTrainees.size(); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }

                        } else {
                            for (int i = 0; i < (Bootcamp.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        }
                    }
                }
            }
        }
        if (displacedTrainees.size() > 0) {
            SimulationImpl simulation = new SimulationImpl();
            simulation.addDisplacedTraineesToWaitingList(displacedTrainees);
        }
    }
}