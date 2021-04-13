package com.sparta.eng82.objects;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrainingCentre {
    private static final Queue<Trainee> waitingList = new PriorityQueue<>();
    public static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    private static int idIncrementor = 0;
    private final int id;
    private final Trainee[] traineeArray = new Trainee[100];

    public TrainingCentre() {
        id = idIncrementor++;
    }

    public boolean addToWaitingList(Trainee t) {
        try {
            waitingList.add(t);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public int getId() {
        return id;
    }
}
