package com.CBTSystem.Database;

import com.CBTSystem.DataModel.SoalDataModel;
import com.CBTSystem.DataModel.UserDataModel;

import javax.swing.*;
import java.util.ArrayList;

public class DatabaseControler {
    private Database database = new Database();

    public boolean pushSoal(String soal, String[] jawab,String jawaban_benar){
        try{
            database.getSoal().add(new SoalDataModel(soal,jawab,jawaban_benar));
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean updateSoal(String soal, String[] jawab,String jawaban_benar,int index){
        try{
            database.getSoal().set(index,new SoalDataModel(soal,jawab,jawaban_benar));
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean pushUser(String username, String password, String role){
        try{
            //checking username
            boolean validate = false;
            for(int j = 0; j < database.getUser().size();j++){
               if(database.getUser().get(j).getUserUsername().equals(username)){
                   validate = true;
               }
            }
            //add user
            if (!validate){
                database.getUser().add(new UserDataModel(username,password,role));
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"User Sudah Ada Gunakan Nama Username lain!!");
            }
            return false;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    //signin get data
    public String signInWithUsernameAndPassword(String username, String password){
        for(int i = 0 ;i<database.getUser().size();i++){
            if(database.getUser().get(i).getUserUsername().equals(username)
            && database.getUser().get(i).getUserPassword().equals(password)){
                return database.getUser().get(i).getUserRole();
            }
        }
        return "";
    }
    //getdata soal
    public ArrayList<SoalDataModel> getSoal() { return database.getSoal(); }
}
