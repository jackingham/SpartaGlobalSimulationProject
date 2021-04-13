package com.sparta.eng82.objects;

public class Trainee {
    private final int id;
    private final int joinMonth;
    private static int idIncrementor = 0;


    public Trainee(int joinMonth) {
        this.joinMonth = joinMonth;
        id = idIncrementor++;
    }

    public int getId() {
        return id;
    }

    public int getJoinMonth() {
        return joinMonth;
    }
}


