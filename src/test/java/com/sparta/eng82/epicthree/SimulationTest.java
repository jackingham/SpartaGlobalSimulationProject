package com.sparta.eng82.epicthree;

import com.sparta.eng82.epicthree.simulation.Simulation;
import com.sparta.eng82.epicthree.simulation.SimulationImpl;
import com.sparta.eng82.objects.TrainingCentre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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