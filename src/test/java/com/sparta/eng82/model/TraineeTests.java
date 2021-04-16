package com.sparta.eng82.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeTests {
    static Trainee trainee = new Trainee(5);

    CourseTypes traineeCourse = trainee.getCourseName();
    int traineeID = trainee.getId();

    @Test
    public void shouldReturnTheMonthTheTraineeJoined() {
        Assertions.assertEquals(5, trainee.getJoinMonth());
    }

    @Test
    public void shouldReturnTheCourseTypeOfTheEmployee() {
        Assertions.assertEquals(traineeCourse, trainee.getCourseName());
    }

    @Test
    public void shouldReturnTheIdOfTheTrainee() {
        Assertions.assertEquals(traineeID, trainee.getId());
    }


}
