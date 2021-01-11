package com.CBTSystem;

import com.CBTSystem.Database.DatabaseControler;

import javax.swing.*;
import java.awt.*;

public class LoginAndRegister extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel loginandregisterlayout;
    private JComboBox roleField;
    private JButton trueRegisterButton;
    private JLabel registerlabel;


    public LoginAndRegister(DatabaseControler databaseControler, Comunicator comunicator){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 500));
        setContentPane(loginandregisterlayout);
        pack();

        roleField.setModel(new DefaultComboBoxModel(new String[] { "DOSEN",
                "SISWA"}));

        roleField.setVisible(false);
        trueRegisterButton.setVisible(false);

        loginButton.addActionListener(view->{
            String username =  usernameField.getText();
            String password = passwordField.getText();
            String return_data = databaseControler.signInWithUsernameAndPassword(username,password);
            if(return_data!=""){
                comunicator.loginRegisterView(false);
                if(return_data.equals("DOSEN")){
                    //dosen
                    comunicator.menuDosenView(true);
                }else{
                    //siswa
                    comunicator.startLayout(true);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Failed To Login!!");
            }
        });

        registerButton.addActionListener(view->{
            roleField.setVisible(true);
            trueRegisterButton.setVisible(true);
            registerButton.setVisible(false);
            loginButton.setVisible(false);
            registerlabel.setVisible(false);
        });

        trueRegisterButton.addActionListener(view->{
            String username =  usernameField.getText();
            String password = passwordField.getText();
            String role = roleField.getSelectedItem().toString();
            if(databaseControler.pushUser(username,password,role)){
                JOptionPane.showMessageDialog(null,"User Berhasil Di Buat Silahkan Login!!");
                roleField.setVisible(false);
                trueRegisterButton.setVisible(false);
                registerButton.setVisible(true);
                loginButton.setVisible(true);
                registerlabel.setVisible(true);
            }
        });
    }
}
