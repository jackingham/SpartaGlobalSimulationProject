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
    String responseThree;
    String[] responses = new String[3];



    public static void main(String[] args){
        new UI();
    }

    public UI(){
        JFrame frame1 = new JFrame("SpartaGlobal Academy Simulation");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 250);


        JPanel  mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

//        JPanel subPanel1 = new JPanel(); // sub-panel 1
//        subPanel1.add(new JLabel("Panel One", SwingConstants.CENTER));


        Box titleText = Box.createHorizontalBox();
        JLabel title = new JLabel("<html><span style='color: teal;'>SpartaGlobal Academy Simulation</span></html>", SwingConstants.CENTER);
        title.setFont (title.getFont().deriveFont(24.0f));
        titleText.add(title);
        titleText.setAlignmentX(frame1.getWidth() / 2);

        JPanel topPanel = new JPanel();
        topPanel.add(titleText);
        topPanel.setBackground(Color.white);


        JPanel bottomPanel2 = new JPanel();
        bottomPanel2.setBackground(Color.white);
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


        JPanel bottomPanel3 = new JPanel();
        bottomPanel3.setBackground(Color.white);
        JLabel monthlyOutputLabel = new JLabel("Would you like the output monthly ? \n",SwingConstants.CENTER);
        JRadioButton monthlyOutput = new JRadioButton();
        bottomPanel3.add(monthlyOutputLabel);
        bottomPanel3.add(monthlyOutput);

        JPanel bottomPanel4 = new JPanel();
        JLabel labelYears = new JLabel("Years:");
        JTextField years = new JTextField(3);
        JLabel labelMonths = new JLabel("Months:");
        JTextField months = new JTextField(3);
        JButton send = new JButton("Submit");
        JButton reset = new JButton("Clear");
        bottomPanel4.add(labelYears);
        bottomPanel4.add(years);
        bottomPanel4.add(labelMonths);
        bottomPanel4.add(months);
        bottomPanel4.add(send);
        bottomPanel4.add(reset);

        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel2);
        mainPanel.add(bottomPanel4);
        mainPanel.add(bottomPanel3);

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
                    responses[1] = years.getText();
                    responses[2] = "0";
                }
                else if( monthsRadio.isSelected()){
                    responseTwo = "m";
                    responses[0] = responseTwo;
                    responses[1] = "0";
                    responses[2] = months.getText();
                }
                else if( yAndMRadio.isSelected()){
                    responseThree = "ym";
                    responses[0] = responseThree;
                    responses[1] = years.getText();
                    responses[2] = months.getText();
                }
                else{
                    responses[0] = "m";
                    responses[1] = "0";
                    responses[2] = "0";
                }


                SimulationImpl simulation = new SimulationImpl();
                simulation.startSimulation(InputValidatorForUI.getUserInput(responses[0], Integer.parseInt(responses[1]),Integer.parseInt(responses[2])), monthlyOutput.isSelected());

            }
        });
        frame1.getContentPane().add(mainPanel);
        frame1.setVisible(true);
    }
}
