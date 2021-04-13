package com.sparta.eng82;

import com.sparta.eng82.View.OutputManager;
import com.sparta.eng82.objects.TrainingCentre;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private List<TrainingCentre> listOfCentres = new ArrayList<>();

    OutputManager outputManager = new OutputManager(listOfCentres);

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
