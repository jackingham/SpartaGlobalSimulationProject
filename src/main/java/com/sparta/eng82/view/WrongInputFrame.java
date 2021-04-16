package com.sparta.eng82.view;

import javax.swing.*;
import java.awt.*;

public class WrongInputFrame extends JFrame {
    JLabel label;


    public WrongInputFrame() {
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        label = new JLabel("Wrong Input");
        label.setBounds(10, 50, 80, 25);

        this.add(label);
        this.pack();
        this.setVisible(false);
    }
}
