package com.sparta.eng82.controller;

import com.sparta.eng82.controller.Simulation;
import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.TrainingCentre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulationTest {

    Simulation sim = null;

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
}