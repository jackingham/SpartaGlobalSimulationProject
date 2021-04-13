package com.sparta.eng82;

import com.sparta.eng82.controller.SimulationImpl;

public class App {

    public static void main(String[] args) {
        SimulationImpl simulation = new SimulationImpl();
        simulation.startSimulation(1000000);
    }
}
