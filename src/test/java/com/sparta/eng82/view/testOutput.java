package com.sparta.eng82.view;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class testOutput {

    @Test
    @DisplayName("Test for the output of number of centres")
    public void shouldReturnNumberOfCentres() {

        TrainingCentre trainingCentre = new TrainingCentre();
        List<TrainingCentre> listOfCentres = new ArrayList<>();
        List<Trainee> listOfTrainee = new ArrayList<>();
        OutputManager outputManager = new OutputManager(listOfCentres, listOfTrainee);

        listOfCentres.add(trainingCentre);

        Assertions.assertEquals(1, outputManager.numberOfCentres());
    }

    @Test
    @DisplayName("Test for the output of number of open centres")
    public void shouldReturnNumberOfOpenCentres() {

        TrainingCentre trainingCentre = new TrainingCentre();
        List<TrainingCentre> listOfCentres = new ArrayList<>();
        List<Trainee> listOfTrainee = new ArrayList<>();
        OutputManager outputManager = new OutputManager(listOfCentres, listOfTrainee);

        listOfCentres.add(trainingCentre);

        Assertions.assertEquals(1, outputManager.numberOfOpenCentres());
    }

    @Test
    @DisplayName("Test for the output of number of full centres")
    public void shouldReturnNumberOfFullCentres() {

        TrainingCentre trainingCentre = new TrainingCentre();
        TrainingCentre trainingCentre1 = new TrainingCentre();
        TrainingCentre trainingCentre2 = new TrainingCentre();
        TrainingCentre trainingCentre3 = new TrainingCentre();

        List<TrainingCentre> listOfCentres = new ArrayList<>();
        List<Trainee> listOfTrainee = new ArrayList<>();
        OutputManager outputManager = new OutputManager(listOfCentres, listOfTrainee);

        listOfCentres.add(trainingCentre);
        listOfCentres.add(trainingCentre1);
        listOfCentres.add(trainingCentre2);
        listOfCentres.add(trainingCentre3);

        trainingCentre.setFull();
        trainingCentre2.setFull();

        Assertions.assertEquals(2, outputManager.numberOfFullCentres());
    }
}
