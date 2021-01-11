package com.CBTSystem;

import com.CBTSystem.DataModel.SoalDataModel;
import com.CBTSystem.Database.DatabaseControler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewSoal extends JFrame {
    private JTextArea soalHolder;
    private JRadioButton jawaban1;
    private JRadioButton jawaban2;
    private JRadioButton jawaban3;
    private JButton selanjutnyaButton;
    private JPanel viewsoalLayout;
    private JLabel progressSoal;
    private DatabaseControler databaseControler;
    private int soalBenar = 0;
    private List<SoalDataModel> soalData;

    public ViewSoal(DatabaseControler databaseControler, Comunicator comunicator){
        this.databaseControler = databaseControler;
        setContentPane(viewsoalLayout);
        setPreferredSize(new Dimension(550, 500));
        pack();

        ButtonGroup button = new ButtonGroup();
        button.add(jawaban1);
        button.add(jawaban2);
        button.add(jawaban3);

        soalHolder.setEditable(false);

        try{
            selanjutnyaButton.addActionListener(view->{
                if(jawaban1.isSelected()||jawaban2.isSelected()||jawaban3.isSelected()){
                    if(jawaban1.isSelected()){
                        if(soalData.get(comunicator.getSoalIndex())
                                .getJawaban_benar().equals(jawaban1.getText())){
                            soalBenar++;
                        }

                    }else if(jawaban2.isSelected()){
                        if(soalData.get(comunicator.getSoalIndex())
                                .getJawaban_benar().equals(jawaban2.getText())){
                            soalBenar++;
                        }
                    }else if(jawaban3.isSelected()){
                        if(soalData.get(comunicator.getSoalIndex())
                                .getJawaban_benar().equals(jawaban3.getText())){
                            soalBenar++;
                        }
                    }
                    if(comunicator.getSoalIndex()==databaseControler.getSoal().size()-2){
                        selanjutnyaButton.setText("Submit");
                    }
                    if(comunicator.getSoalIndex()!=databaseControler.getSoal().size()-1){
                        comunicator.setSoalIndex(comunicator.getSoalIndex()+1);
                        loadSoal(comunicator.getSoalIndex());
                        button.clearSelection();
                    }else{
                        Double nilaiPerSoal = 100/Double.valueOf(databaseControler.getSoal().size());
                        comunicator.setScore(soalBenar*nilaiPerSoal);
                        System.out.println(comunicator.getScore());
                        //go to score layout
                        comunicator.viewSoalLayout(false);
                        comunicator.showHasilLayout(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Pilih jawabanmu duluu!!");
                }
            });
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Soal Mungkin Belum Tersedia!!");
        }

    }

    public void loadSoal(int index){
        System.out.println("Load Soal......");
        progressSoal.setText((index+1)+"-"+databaseControler.getSoal().size());
        soalData = new ArrayList<>(databaseControler.getSoal());
        Collections.shuffle(soalData);
        SoalDataModel dataSoal = soalData.get(index);
        String[] pilihanGanda = Arrays.copyOf(dataSoal.getJawaban(),dataSoal.getJawaban().length);
        List<String> jawabanList = Arrays.asList(pilihanGanda);
        Collections.shuffle(jawabanList);
        soalHolder.setText(dataSoal.getSoal());
        jawaban1.setText(jawabanList.get(0));
        jawaban2.setText(jawabanList.get(1));
        jawaban3.setText(jawabanList.get(2));
    }
}
