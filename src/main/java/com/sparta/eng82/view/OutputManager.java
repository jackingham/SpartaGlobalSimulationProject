package com.sparta.eng82.view;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.*;
import com.sparta.eng82.utilities.FileOutput;
import com.sparta.eng82.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class OutputManager {

    public void generateReport(SimulationImpl simulation, int month) {
        OutputManager outputManager = new OutputManager();
        FileOutput fileOutput = new FileOutput();

        String monthMessage = "\n##### Month: " + month + " #####";
        Printer.printMessage(monthMessage);
        fileOutput.appendToFile(monthMessage);

        // number of open centres
        String openCentrePerType = "-- Number of Open Centres per Type --";
        Printer.printMessage(openCentrePerType);
        fileOutput.appendToFile(openCentrePerType);

        HashMap<String, Integer> temp = null;

        temp = outputManager.getNumberOfOpenCentres();

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String output = "Centre: " + entry.getKey() + " Count: " + entry.getValue().toString();
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
        if (temp.isEmpty()) {
            String output = "...there are no open centres";
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }

        temp = outputManager.getNumberOfClosedCentres();
        // number of closed centres
        String closedCentrePerType = "\n-- Number of Closed Centres per Type --";
        Printer.printMessage(closedCentrePerType);
        fileOutput.appendToFile(closedCentrePerType);

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String output = "Centre: " + entry.getKey() + " Count: " + entry.getValue().toString();
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
        if (temp.isEmpty()) {
            String output = "...there are no closed centres";
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }

        temp = outputManager.getNumberOfFullCentres();
        // number of full centres
        String fullCentresPerType = "\n-- Number of Full Centres per Type --";
        Printer.printMessage(fullCentresPerType);
        fileOutput.appendToFile(fullCentresPerType);

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String output = "Centre: " + entry.getKey() + " Count: " + entry.getValue().toString();
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
        if (temp.isEmpty()) {
            String output = "...there are no full centres";
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }

        temp = outputManager.getNumberOfCurrentTrainees();
        // number of current trainees in training
        String currentTrainesInTraining = "\n-- Number of Trainees in Training -- ";
        Printer.printMessage(currentTrainesInTraining);
        fileOutput.appendToFile(currentTrainesInTraining);

        for (Map.Entry<String, Integer> entry : outputManager.getNumberOfCurrentTrainees().entrySet()) {
            String output = "Centre: " + entry.getKey() + " Count: " + entry.getValue().toString();
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
        if (temp.isEmpty()) {
            String output = "...there are no current trainees in training";
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }

        temp = outputManager.getNumberOfTraineesWaiting(simulation);
        // number of current traines on waiting list
        String traineesWaitingList = "\n-- Number of Trainees on the Waiting List --";
        Printer.printMessage(traineesWaitingList);
        fileOutput.appendToFile(traineesWaitingList);

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            String output = "Course: " + entry.getKey() + " Count: " + entry.getValue().toString();
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
        if (temp.isEmpty()) {
            String output = "...there are no trainees on the waiting list";
            Printer.printMessage(output);
            fileOutput.appendToFile(output);
        }
    }

    //TODO make Private!
    public HashMap<String, Integer> getNumberOfOpenCentres() {

        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && !((TechCentre) trainingCentre).full()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && !((Bootcamp) trainingCentre).full()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && !((TrainingHub) trainingCentre).full()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    private HashMap<String, Integer> getNumberOfClosedCentres() {
        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && !trainingCentre.getFunctionStatus()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && !trainingCentre.getFunctionStatus()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && !trainingCentre.getFunctionStatus()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }


    private HashMap<String, Integer> getNumberOfFullCentres() {
        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && ((TechCentre) trainingCentre).full()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && ((Bootcamp) trainingCentre).full()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && ((TrainingHub) trainingCentre).full()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    private HashMap<String, Integer> getNumberOfCurrentTrainees() {
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

    private HashMap<String, Integer> getNumberOfTraineesWaiting(SimulationImpl simulation) {
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
