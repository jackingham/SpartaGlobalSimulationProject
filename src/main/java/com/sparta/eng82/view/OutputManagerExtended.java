package com.sparta.eng82.view;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.CentreTypes;
import com.sparta.eng82.model.TrainingCentre;

import java.util.HashMap;
import java.util.Map;

public class OutputManagerExtended {

    public static void main(String[] args) {
        OutputManagerExtended outputManagerExtended = new OutputManagerExtended();
        SimulationImpl simulation = new SimulationImpl();

        simulation.startSimulation(5, false);

        HashMap<String, Integer> temp = outputManagerExtended.getNumberOfOpenCentres();

        for (Map.Entry<String, Integer> entry : temp.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }
    }

    HashMap<String, Integer> getNumberOfOpenCentres(){

        int totalTech = 0;
        int totalBootcamp = 0;
        int totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre: SimulationImpl.trainingCentres){
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && trainingCentre.isOpen()){
                // if tech
                totalTech ++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp")  && trainingCentre.isOpen()){
                // if bootcamp
                totalBootcamp ++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub")  && trainingCentre.isOpen()){
                // if training hub
                totalTrainingHub ++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }

        }
        return temp;
    }

    // TODO number of closed centres

    int getNumberOfFullCentres(){
        int total = 0;
        for (TrainingCentre trainingCentre: SimulationImpl.trainingCentres){
            if (!trainingCentre.isOpen()){
                total++;
            }
        }
        return total;
    }

    int getNumberOfCurrentTrainees(){
        int total = 0;
        for (TrainingCentre trainingCentre: SimulationImpl.trainingCentres){
            total += trainingCentre.getTraineeArraySize();
        }
        return total;
    }

    int getNumberOfTraineesWaiting(SimulationImpl simulation){
        return simulation.getWaitingList().size();
    }
}
