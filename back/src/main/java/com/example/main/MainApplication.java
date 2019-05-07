package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


@SpringBootApplication
public  class MainApplication  {
    static JButton on , off;


 /*   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == on) {

        } else if (e.getSource() == off) {


        }
    }*/
    /*private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1350,730);

        frame.setLayout(null);

        on = new JButton("nowa klasa");
        on.setBounds(0,310,90,20);
        frame.add(on);
        on.addActionListener(this);

        off = new JButton("usuń utworzoną");
        off.setBounds(90,310,120,20);
        frame.add(off);
        off.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }*/


    public static void main (String[] args) {
        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });*/
        SpringApplication.run(MainApplication.class,args);

    }
}
