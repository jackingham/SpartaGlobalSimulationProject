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
                //System.out.println("Type Name::"+centre.getClass().getTypeName());
                if (centre.getClass().getTypeName().equals("com.sparta.eng82.model.Bootcamp")) { // checks if the current centre is a bootcamp
                    System.out.println(numberOfTrainees);
                    System.out.println("IF Bootcamp size month::" + ((Bootcamp) centre).getNumberOfMonthsBelowRequiredAttendance());
                    if (((Bootcamp) centre).getNumberOfMonthsBelowRequiredAttendance() == 2) { // checks if bootcamp has been active with low attendance for 3 months
                        //((Bootcamp) centre).incrementNumberOfMonthsBelowRequiredAttendance();//I want to uncomment
                        displacedTrainees.addAll(centre.getTraineeArray()); // if true, removes students and adds them to an internal waiting list
                        centre.removeAllTrainees();
                        //what about the open status. Won't you set it to false?
                        centre.setFunctionStatus(false); // closes the centre
                    } else {
                        ((Bootcamp) centre).incrementNumberOfMonthsBelowRequiredAttendance(); // if less than 3 months of low attendance, increments by one month
                        System.out.println("ELSE Bootcamp size month::" + ((Bootcamp) centre).getNumberOfMonthsBelowRequiredAttendance());
                    }
                } else {
                    displacedTrainees.addAll(centre.getTraineeArray()); // if not bootcamp remove students and add to internal waiting list
                    centre.removeAllTrainees();
                    centre.setFunctionStatus(false); // closes the centre
                }
            }
//             else if (centreWithSpace == null) { // checks if receiving centre is "null" //isn't all centreWithSpace==null at the first go
//                centreWithSpace = centre; // current centre becomes available for intake
//                System.out.println("Checking centreWithSpace::"+centreWithSpace);
//            }
            //Mending code here-Astha-I do not want it to go to the bootcamp always
            else {
                centreWithSpace = centre;
                System.out.println("CentreWithSpace::" + centreWithSpace.getClass().getTypeName() + " centreWithSpace.getTraineeArraySize() " + centreWithSpace.getTraineeArraySize());

                if (centreWithSpace.getClass().getTypeName().equals("TechCentre")) { // if the current "centre with space" is a TechCentre
                    if (centreWithSpace.getTraineeArraySize() > TechCentre.getMaximumCapacity() - 10) {

                        centreWithSpace = centre;
                    }
                } else if (centreWithSpace.getClass().getTypeName().equals("TrainingHub")) {
                    if (centreWithSpace.getTraineeArraySize() > TrainingHub.getMaximumCapacity() - 10) {

                        centreWithSpace = centre;
                    }
                } else if (centreWithSpace.getClass().getTypeName().equals("com.sparta.eng82.model.Bootcamp")) {

                    ((Bootcamp) centreWithSpace).resetNumberOfMonthsBelowRequiredAttendance();//I want to comment
//                if (centreWithSpace.getTraineeArraySize() > (Bootcamp.getMaximumCapacity() - 10)) { // I am not sure what does this mean so commenting
//
//                    centreWithSpace = centre;
//                }
//                if (!((Bootcamp) centreWithSpace).full()) {
//                    if ((Bootcamp.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()) >= 10) {
//                        for (int i = 0; i < 10; i++) {
//                            centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
//                        }
//
//                    }
//                }

                    //I would still contest doing something else
                    if(!((Bootcamp) centreWithSpace).full()) {
                        if ((Bootcamp.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()) >= displacedTrainees.size()) {
                            for (int i = 0; i < displacedTrainees.size(); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }

                        }
                        else{
                            for (int i = 0; i < (Bootcamp.getMaximumCapacity() - centreWithSpace.getTraineeArraySize()); i++) {
                                centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
                            }
                        }
                    }
                } else {
                    if (displacedTrainees.size() >= 10) { //From this I understand that at a time you are displacing just 10 to a centre-did the re
                        System.out.println(centreWithSpace.getClass().getTypeName() + "entering here");
                        for (int i = 0; i < 10; i++) {
                            centreWithSpace.getTraineeArray().add(displacedTrainees.get(i));
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