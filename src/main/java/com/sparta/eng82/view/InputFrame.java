package com.sparta.eng82.view;

import com.sparta.eng82.controller.SimulationImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame implements ActionListener {
    JFrame frame1;
    JPanel bottomPanel3, bottomPanel2, topPanel, mainPanel, bottomPanel4;
    JRadioButton monthlyOutput;
    JLabel labelYears, labelMonths, monthlyOutputLabel, label2, yAndMLabel, monthsLabel, yearsLabel, title;
    JTextField months, years;
    JButton send, reset;
    SimulationImpl simulation = new SimulationImpl();
    WrongInputFrame outputFrame = new WrongInputFrame();
    private int numberOfYears = 0;
    private int numberOfMonths = 0;
    private boolean check;
    private boolean parseInt, monthChecker, yearChecker;

    public InputFrame() {
        frame1 = new JFrame("SpartaGlobal Academy Simulation");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 250);


        mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));


        Box titleText = Box.createHorizontalBox();
        title = new JLabel("<html><span style='color: teal;'>SpartaGlobal Academy Simulation</span></html>", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(24.0f));
        titleText.add(title);
        titleText.setAlignmentX(frame1.getWidth() / 2);

        topPanel = new JPanel();
        topPanel.add(titleText);
        topPanel.setBackground(Color.white);


        bottomPanel2 = new JPanel();
        bottomPanel2.setBackground(Color.white);


        yearsLabel = new JLabel("Years");
        monthsLabel = new JLabel("Months");
        yAndMLabel = new JLabel("Both");

        label2 = new JLabel("Enter The time from in years and months to run the simulation:\n");


        bottomPanel2.add(yearsLabel);
        bottomPanel2.add(monthsLabel);
        bottomPanel2.add(yAndMLabel);
        bottomPanel2.add(label2);


        bottomPanel3 = new JPanel();
        bottomPanel3.setBackground(Color.white);
        monthlyOutputLabel = new JLabel("Would you like the output monthly ? \n", SwingConstants.CENTER);
        monthlyOutput = new JRadioButton();
        bottomPanel3.add(monthlyOutputLabel);
        bottomPanel3.add(monthlyOutput);

        bottomPanel4 = new JPanel();
        labelYears = new JLabel("Years:");
        years = new JTextField("0",3);

        labelMonths = new JLabel("Months:");
        months = new JTextField("0",3);
        send = new JButton("Submit");
        send.addActionListener(this);
        bottomPanel4.add(labelYears);
        bottomPanel4.add(years);
        bottomPanel4.add(labelMonths);
        bottomPanel4.add(months);
        bottomPanel4.add(send);


        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel2);
        mainPanel.add(bottomPanel4);
        mainPanel.add(bottomPanel3);


        frame1.getContentPane().add(mainPanel);
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == send) {
            parseInt = true;
            monthChecker = true;
            yearChecker = true;
            try {
                numberOfYears = Integer.parseInt(years.getText());
                numberOfMonths = Integer.parseInt(months.getText());
            } catch (NumberFormatException er) {
                parseInt = false;
            }
            if (numberOfYears < 0 && numberOfMonths <= 0) {
                monthChecker = false;
                yearChecker = false;
                outputFrame.setVisible(true);
                System.out.println("error months and years less than 0");
            } else if (numberOfMonths <= 0) {
                monthChecker = false;
                outputFrame.setVisible(true);
                System.out.println("months less than 0");
            } else if (numberOfYears < 0) {
                yearChecker = false;
                outputFrame.setVisible(true);
                System.out.println("year less than 0");
            }


            check = monthlyOutput.isSelected();
            if (parseInt && yearChecker && monthChecker) {
                int totalNumberOfMonths = (numberOfYears * 12) + numberOfMonths;
                simulation.startSimulation(totalNumberOfMonths, check);
            } else if (!parseInt) {
                outputFrame.setVisible(true);
                System.out.println("error");
            }

        }
    }
}


