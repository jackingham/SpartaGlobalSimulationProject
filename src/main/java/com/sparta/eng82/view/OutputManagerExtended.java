package com.sparta.eng82.view;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;

import java.util.HashMap;
import java.util.Map;

public class OutputManagerExtended {

    public static void main(String[] args) {

        SimulationImpl simulation = new SimulationImpl();

        simulation.startSimulation(11, false);

        generateReport(simulation);

    }

    static void generateReport(SimulationImpl simulation) {
        OutputManagerExtended outputManagerExtended = new OutputManagerExtended();
        // number of open centres
        System.out.println("-- Number of Open Centres per Type --");
        HashMap<String, Integer> temp = null;

        temp = outputManagerExtended.getNumberOfOpenCentres();

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no open centres");
        }

        // number of closed centres
        // TODO

        temp = outputManagerExtended.getNumberOfFullCentres();
        // number of full centres
        System.out.println("\n-- Number of Full Centres per Type --");
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no full centres");
        }

        temp = outputManagerExtended.getNumberOfCurrentTrainees();
        // number of current trainees in training
        System.out.println("\n-- Number of Trainees in Training -- ");
        for (Map.Entry<String, Integer> entry : outputManagerExtended.getNumberOfCurrentTrainees().entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no current trainees in training");
        }

        temp = outputManagerExtended.getNumberOfTraineesWaiting(simulation);
        // number of current traines on waiting list
        System.out.println("\n-- Number of Trainees on the Waiting List --");
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Course: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no trainees on the waiting list");
        }
    }

    HashMap<String, Integer> getNumberOfOpenCentres() {

        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && trainingCentre.isOpen()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && trainingCentre.isOpen()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && trainingCentre.isOpen()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    // TODO number of closed centres

    HashMap<String, Integer> getNumberOfFullCentres() {
        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && !trainingCentre.isOpen()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && !trainingCentre.isOpen()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && !trainingCentre.isOpen()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    HashMap<String, Integer> getNumberOfCurrentTrainees() {
        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre")) {
                // if tech
                totalTech += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp")) {
                // if bootcamp
                totalBootcamp += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub")) {
                // if training hub
                totalTrainingHub += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    HashMap<String, Integer> getNumberOfTraineesWaiting(SimulationImpl simulation) {
        int totalJava = 0;
        int totalCsharp = 0;
        int totalData = 0;
        int totalDevops = 0;
        int totalBusiness = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (Trainee trainee : simulation.getWaitingList()) {
            if (trainee.getCourseName().toString().equals("JAVA")) {
                totalJava += 1;
                temp.put("Java", totalJava);
            }
            if (trainee.getCourseName().toString().equals("C_SHARP")) {
                totalCsharp += 1;
                temp.put("C#", totalCsharp);
            }
            if (trainee.getCourseName().toString().equals("DATA")) {
                totalData += 1;
                temp.put("Data", totalData);
            }
            if (trainee.getCourseName().toString().equals("DEVOPS")) {
                totalDevops += 1;
                temp.put("DevOps", totalDevops);
            }
            if (trainee.getCourseName().toString().equals("BUSINESS")) {
                totalBusiness += 1;
                temp.put("Business", totalBusiness);
            }
        }
        return temp;
    }
}
