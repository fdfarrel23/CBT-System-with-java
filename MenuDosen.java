package com.CBTSystem;

import com.CBTSystem.Database.DatabaseControler;

import javax.swing.*;
import java.awt.*;

public class MenuDosen extends JFrame{
    private JList listSoal;
    private JButton tambahSoal;
    private JPanel menuLayout;
    private JButton logoutButton;
    private DefaultListModel<String> soal = new DefaultListModel<>();
    private DatabaseControler databaseControler;

    public MenuDosen(DatabaseControler databaseControler,Comunicator comunicator){
        this.databaseControler = databaseControler;
        setContentPane(menuLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 500));
        pack();

        for (int i = 0 ;i<databaseControler.getSoal().size();i++){
            soal.addElement(
                    (i+1)+" "+databaseControler.getSoal().get(i).getSoal()
            );
        }

        tambahSoal.addActionListener(view->{
            comunicator.menuDosenView(false);
            comunicator.addSoalView(true);
        });

        listSoal.setModel(soal);

        listSoal.addListSelectionListener(view->{
            if(listSoal.getSelectedIndex()!=-1){
                comunicator.setStatus(1);
                comunicator.setIndex(listSoal.getSelectedIndex());
                comunicator.menuDosenView(false);
                comunicator.addSoalView(true);
            }
        });

        logoutButton.addActionListener(view->{
            comunicator.menuDosenView(false);
            comunicator.loginRegisterView(true);
        });
    }

    public void updateSoal(){
        soal.clear();
        for (int i = 0 ;i<databaseControler.getSoal().size();i++){
            soal.addElement(
                    (i+1)+" "+databaseControler.getSoal().get(i).getSoal()
            );
        }
    }
}
