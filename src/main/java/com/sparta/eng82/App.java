package com.sparta.eng82;

import com.sparta.eng82.objects.TrainingCentre;
import com.sparta.eng82.utilities.InputValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    private List<TrainingCentre> listOfCentres = new ArrayList<>();

    public static void main( String[] args )
    {
        System.out.println(InputValidator.getUserInput());
    }
}
