package com.sparta.eng82.view;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class testOutput {
    private static final Queue<Trainee> waitingList = new PriorityQueue<>();
    //    public static final Logger logger = LogManager.getLogger(testOutput.class);
    TrainingCentre trainingCentre = new TrainingCentre();
    TrainingCentre trainingCentre1 = new TrainingCentre();
    TrainingCentre trainingCentre2 = new TrainingCentre();
    TrainingCentre trainingCentre3 = new TrainingCentre();
    Trainee trainee = new Trainee(1);
    List<TrainingCentre> listOfCentres = new ArrayList<>();
    List<Trainee> listOfTrainee = new ArrayList<>();
    OutputManager outputManager = new OutputManager(listOfCentres, listOfTrainee, waitingList);


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

//    @Test
//    @DisplayName("Test for the output of number of full centres")
//    public void shouldReturnNumberOfFullCentres() {
//        listOfCentres.add(trainingCentre);
//        listOfCentres.add(trainingCentre1);
//        listOfCentres.add(trainingCentre2);
//        listOfCentres.add(trainingCentre3);
//
//        trainingCentre.isOpen();
//        trainingCentre2.isOpen();
//
//        Assertions.assertEquals(2, outputManager.numberOfFullCentres());
//    }

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
