package com.sparta.eng82.objects;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrainingCentre {
    private static int idIncrementor = 0;
    private Trainee[] traineeArray = new Trainee[100];

    private static Queue<Trainee> waitingList = new PriorityQueue<>();

    public boolean addToWaitingList(Trainee t){
        try {
            waitingList.add(t);
            return true;
        } catch (IllegalStateException e){
            return false;
        }
    }


}
