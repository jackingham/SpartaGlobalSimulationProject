package com.sparta.eng82.view;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class testOutput {
    private static final Queue<Trainee> waitingList = new LinkedList<>();
    //    public static final Logger logger = LogManager.getLogger(testOutput.class);
    TrainingCentre trainingCentre = new TrainingCentre();
    Trainee trainee = new Trainee(1);
    ArrayList<TrainingCentre> listOfCentres = new ArrayList<>();
    OutputManager outputManager = new OutputManager(listOfCentres, waitingList);


    @Test
    @DisplayName("Test for the output of number of centres")
    public void shouldReturnNumberOfCentres() {
        listOfCentres.add(trainingCentre);
        Assertions.assertEquals(1, outputManager.numberOfCentres());
    }

    @Test
    @DisplayName("Test for the output of number of open centres")
    public void shouldReturnNumberOfOpenCentres() {
        listOfCentres.add(trainingCentre);

        Assertions.assertEquals(1, outputManager.numberOfOpenCentres());
    }


    @Test
    @DisplayName("Test for the output of number of trainees")
    public void shouldReturnNumberOfTrainees() {
        listOfCentres.add(trainingCentre);

        trainingCentre.getTraineeArray().add(new Trainee(1));
        trainingCentre.getTraineeArray().add(new Trainee(1));
        trainingCentre.getTraineeArray().add(new Trainee(1));

        Assertions.assertEquals(3, outputManager.numberOfTraineesInTraining());
    }

    @Test
    @DisplayName("Test for the output of number of trainees")
    public void shouldReturnNumberOfWaitingList() {
        waitingList.add(trainee);

        Assertions.assertEquals(1, outputManager.numberOfTraineesInWaiting());
    }


}
