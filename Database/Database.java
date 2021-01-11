package com.CBTSystem.Database;

import com.CBTSystem.DataModel.SoalDataModel;
import com.CBTSystem.DataModel.UserDataModel;

import java.util.ArrayList;

public class Database {
    private final ArrayList<UserDataModel> User = new ArrayList();
    private final ArrayList<SoalDataModel> Soal = new ArrayList();

    public ArrayList<UserDataModel> getUser() {
        return User;
    }

    public ArrayList<SoalDataModel> getSoal() {
        return Soal;
    }
}

