package com.sparta.eng82.view.UI;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.utilities.InputValidator;
import com.sparta.eng82.utilities.InputValidatorForUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI {
    String responseOne;
    String responseTwo;
    String responseFour;
    String[] responses = new String[4];



    public static void main(String[] args){
        new UI();
    }

    public UI(){
        JFrame frame1 = new JFrame("SpartaGlobal Academy Simulation");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 150);

        Box titleText = Box.createHorizontalBox();
        JLabel title = new JLabel("<html><span style='color: teal;'>SpartaGlobal Academy Simulation</span></html>");
        title.setFont (title.getFont().deriveFont(24.0f));
        titleText.add(title);
        titleText.setAlignmentX(frame1.getWidth() / 2);

        JPanel topPanel = new JPanel();
        topPanel.add(titleText);


        JPanel bottomPanel2 = new JPanel();
        JLabel label1 = new JLabel("Are you entering months, years or a combination of both?\n");
        label1.setFont (label1.getFont().deriveFont(12.0f));
        JRadioButton yearsRadio = new JRadioButton();
        JRadioButton monthsRadio = new JRadioButton();
        JRadioButton yAndMRadio = new JRadioButton();
        JLabel yearsLabel = new JLabel("Years");
        JLabel monthsLabel = new JLabel("Months");
        JLabel yAndMLabel = new JLabel("Both");
        ButtonGroup yearsAndMonths = new ButtonGroup();

        JLabel label2 = new JLabel("Enter The time from in years and months to run the simulation:\n");

        yearsAndMonths.add(yearsRadio);
        yearsAndMonths.add(monthsRadio);

        bottomPanel2.add(label1);
        bottomPanel2.add(yearsLabel);
        bottomPanel2.add(yearsRadio);
        bottomPanel2.add(monthsLabel);
        bottomPanel2.add(monthsRadio);
        bottomPanel2.add(yAndMLabel);
        bottomPanel2.add(yAndMRadio);
        bottomPanel2.add(label2);



        JPanel bottomPanel = new JPanel();
        JLabel labelYears = new JLabel("Years:");
        JTextField years = new JTextField(3);
        JLabel labelMonths = new JLabel("Months:");
        JTextField months = new JTextField(3);
        JButton send = new JButton("Submit");
        JButton reset = new JButton("Clear");
        bottomPanel.add(labelYears);
        bottomPanel.add(years);
        bottomPanel.add(labelMonths);
        bottomPanel.add(months);
        bottomPanel.add(send);
        bottomPanel.add(reset);




        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                years.setText("");
                months.setText("");
            }
        });

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( yearsRadio.isSelected()){
                    responseOne = "y";
                    responses[0] = responseOne;
                    responses[2] = "0";
                }
                if( monthsRadio.isSelected()){
                    responseTwo = "m";
                    responses[2] = responseTwo;
                    responses[1] = "0";
                }
                if( yAndMRadio.isSelected()){
                    String responseOne = "ym";
                    responses[0] = responseTwo;
                    responses[2] = responseOne;
                }

                responseFour = years.getText();
                responses[3] = responseFour;
                SimulationImpl simulation = new SimulationImpl();
                simulation.startSimulation(InputValidatorForUI.getUserInput(responses[0], Integer.parseInt(responses[1]),Integer.parseInt(responses[2])), responses[3].equals("y"));

            }
        });
        frame1.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame1.getContentPane().add(bottomPanel2);
        frame1.getContentPane().add(BorderLayout.NORTH, topPanel);
        frame1.setVisible(true);
    }
}
