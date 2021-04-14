package com.sparta.eng82.controller;

import com.sparta.eng82.model.Bootcamp;
import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;

import java.util.List;

public class CentreManager {

    public static void closeCentre(List<TrainingCentre> centres) {
        /*TrainingCentre centreWithSpace1;
        TrainingCentre centreWithSpace2;*/
        for (TrainingCentre centre : centres) {
            int numberOfTrainees = centre.getTraineeArraySize();
            if (numberOfTrainees <= 10) {
                if (centre.centreType() == Bootcamp) {
                    if (centre.monthsActive == 3) {
                        getCentreWithSpace(centre.getTraineeArray());
                        centre.isOpen = false;
                    } else {
                        centre.monthsActive++;
                    }
                } else {
                    getCentreWithSpace(centre.getTraineeArray());
                    centre.isOpen() = false;
                }
            } else {
                centreWithSpace1.getTraineeArray().addAll(centre.getTraineeArray());
            }
        }
    }

    public static void getCentreWithSpace(Trainee[]) {

    }


}
