package com.sparta.eng82;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.utilities.InputExtension;
import com.sparta.eng82.utilities.InputValidator;

public class App {
    public static void main(String[] args) {

        SimulationImpl simulation = new SimulationImpl();
        simulation.startSimulation(InputValidator.getUserInput(), InputExtension.outputEveryMonth());

        //System.out.println(chooseTime());

    }

}
