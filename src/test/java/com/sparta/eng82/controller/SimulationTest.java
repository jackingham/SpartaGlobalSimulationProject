package com.sparta.eng82.controller;

import com.sparta.eng82.model.Trainee;
import com.sparta.eng82.model.TrainingCentre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationTest {

    SimulationImpl sim = null;

    @BeforeEach
    void setUp() {
        sim = new SimulationImpl();
    }

    @Test
    void generateTraineesTest() {
        assertEquals(5, sim.generateTrainees(5).size());
    }

    @Test
    void generateTrainingCentreTest() {
        assertEquals(TrainingCentre.class.getTypeName(), sim.generateTrainingCentre().getClass().getTypeName());
    }

    @Test
    void stateMonthTest() {
        sim.startSimulation(10, false);
        assertEquals(11, sim.getMonth());
    }

    @Test
    void traineeCentreState() {
        sim.startSimulation(10, false);
        assertEquals(3, sim.getTrainingCentres().get(3).getId());
    }

    @Test
    void waitingListState() {
        sim.startSimulation(10, false);
        Trainee tempTrainee = new Trainee(1);
        assertEquals(tempTrainee.getClass().getTypeName(), sim.getWaitingList().peek().getClass().getTypeName());
    }
}