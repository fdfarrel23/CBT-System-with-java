package com.CBTSystem;

import javax.swing.*;
import java.awt.*;

public class SiswaStart extends JFrame{
    private JButton mulaiButton;
    private JPanel startlayout;
    public SiswaStart(Comunicator comunicator){
        setContentPane(startlayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 500));
        pack();
        mulaiButton.addActionListener(view->{
            comunicator.setStatus(1);
            comunicator.startLayout(false);
            comunicator.viewSoalLayout(true);
        });
    }
}
