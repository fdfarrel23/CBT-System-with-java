package com.CBTSystem;

import javax.swing.*;
import java.awt.*;

public class ShowHasil extends JFrame {
    private JPanel showHasilLayout;
    private JLabel hasil;
    private Comunicator comunicator;

    public ShowHasil(Comunicator comunicator){
        this.comunicator = comunicator;
        setContentPane(showHasilLayout);
        setPreferredSize(new Dimension(550, 500));
        pack();

    }

    public void setHasil(){
        hasil.setText(Double.toString(comunicator.getScore()));
    }
}
