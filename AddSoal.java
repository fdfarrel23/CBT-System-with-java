package com.CBTSystem;

import com.CBTSystem.DataModel.SoalDataModel;
import com.CBTSystem.Database.DatabaseControler;

import javax.swing.*;
import java.awt.*;

public class AddSoal extends JFrame {
    private JTextArea soal;
    private JTextField jawaban1;
    private JTextField jawaban2;
    private JTextField jawaban3;
    private JButton tambahButton;
    private JRadioButton jawabanKe1RadioButton;
    private JRadioButton jawabanKe2RadioButton;
    private JRadioButton jawabanKe3RadioButton;
    private JPanel tambahSoalLayout;
    private JButton backButton;
    private JButton updateButton;
    private String jawaban = "";
    private Comunicator comunicator;
    private DatabaseControler databaseControler;

    public AddSoal(DatabaseControler databaseControler, Comunicator comunicator){
        this.comunicator = comunicator;
        this.databaseControler = databaseControler;
        setContentPane(tambahSoalLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 500));
        pack();

        backButton.addActionListener(view->{
            comunicator.menuDosenView(true);
            comunicator.addSoalView(false);
            comunicator.setStatus(0);
        });


        ButtonGroup group = new ButtonGroup();
        group.add(jawabanKe1RadioButton);
        group.add(jawabanKe2RadioButton);
        group.add(jawabanKe3RadioButton);

        tambahButton.addActionListener(view->{
            if(jawabanKe1RadioButton.isSelected()){
                jawaban = jawaban1.getText();
            }else if(jawabanKe2RadioButton.isSelected()){
                jawaban = jawaban2.getText();
            }else if(jawabanKe3RadioButton.isSelected()){
                jawaban = jawaban3.getText();
            }

            String data_soal = soal.getText();
            String[] data_jawaban = new String[]{jawaban1.getText(),jawaban2.getText(),jawaban3.getText()};
            if(databaseControler.pushSoal(data_soal,data_jawaban,jawaban)){
                comunicator.setStatus(0);
                soal.setText("");
                jawaban1.setText("");
                jawaban2.setText("");
                jawaban3.setText("");
                group.clearSelection();
                comunicator.menuDosenView(true);
                comunicator.addSoalView(false);
            }else{
                JOptionPane.showMessageDialog(null,"Error input soal!!");
            }
        });

        updateButton.addActionListener(view->{
            if(jawabanKe1RadioButton.isSelected()){
                jawaban = jawaban1.getText();
            }else if(jawabanKe2RadioButton.isSelected()){
                jawaban = jawaban2.getText();
            }else if(jawabanKe3RadioButton.isSelected()){
                jawaban = jawaban3.getText();
            }
            String data_soal = soal.getText();
            String[] data_jawaban = new String[]{jawaban1.getText(),jawaban2.getText(),jawaban3.getText()};

            if(databaseControler.updateSoal(data_soal,data_jawaban,jawaban,comunicator.getIndex())){
                comunicator.setStatus(0);
                soal.setText("");
                jawaban1.setText("");
                jawaban2.setText("");
                jawaban3.setText("");
                group.clearSelection();
                comunicator.menuDosenView(true);
                comunicator.addSoalView(false);
            }else{
                JOptionPane.showMessageDialog(null,"Update error!!");
            }
        });
    }

    public void setLayoutStatus(){
        System.out.println(comunicator.getIndex());
        if(comunicator.getStatus()==0){
            updateButton.setVisible(false);
            tambahButton.setVisible(true);
        }else{
            SoalDataModel data = databaseControler.getSoal().get(comunicator.getIndex());
            tambahButton.setVisible(false);
            updateButton.setVisible(true);
            soal.setText(data.getSoal());
            jawaban1.setText(data.getJawaban()[0]);
            jawaban2.setText(data.getJawaban()[1]);
            jawaban3.setText(data.getJawaban()[2]);
            if(data.getJawaban_benar().equals(data.getJawaban()[0])){
                jawabanKe1RadioButton.setSelected(true);
            }else if(data.getJawaban_benar().equals(data.getJawaban()[1])){
                jawabanKe2RadioButton.setSelected(true);
            }else if(data.getJawaban_benar().equals(data.getJawaban()[2])){
                jawabanKe3RadioButton.setSelected(true);
            }
        }
    }

}
