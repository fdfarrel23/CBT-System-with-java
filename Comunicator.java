package com.CBTSystem;

import com.CBTSystem.Database.DatabaseControler;

public class Comunicator {
    private LoginAndRegister loginAndRegister;
    private MenuDosen menuDosen;
    private AddSoal addSoal;
    private SiswaStart siswaStart;
    private ViewSoal viewSoal;
    private ShowHasil showHasil;
    private int status = 0;
    private int index = 0;
    private int soalIndex = 0;
    private double score = 0;

    public Comunicator(){
        DatabaseControler database = new DatabaseControler();
        this.loginAndRegister = new LoginAndRegister(database,this);
        this.menuDosen = new MenuDosen(database,this);
        this.addSoal = new AddSoal(database,this);
        this.siswaStart = new SiswaStart(this);
        this.viewSoal = new ViewSoal(database,this);
        this.showHasil = new ShowHasil(this);
        loginAndRegister.setVisible(true);
    }

    public void setStatus(int d){ status = d; }
    public int getStatus(){ return status; }
    public void setIndex(int d){
        index = d;
    }
    public int getIndex(){ return index; }
    public void loginRegisterView(boolean b){
        loginAndRegister.setVisible(b);
    }


    public int getSoalIndex() {
        return soalIndex;
    }

    public void setSoalIndex(int soalIndex) {
        this.soalIndex = soalIndex;
    }

    public void menuDosenView(Boolean b){
        menuDosen.setVisible(b);
        if(b){
            menuDosen.updateSoal();
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void startLayout(Boolean d){
        if(d){
            siswaStart.setVisible(true);
        }else{
            siswaStart.dispose();
        }
    }

    public void viewSoalLayout(boolean d){
        viewSoal.setVisible(d);
        if (d){
            viewSoal.loadSoal(soalIndex);
        }
    }

    public void showHasilLayout(boolean d){
        showHasil.setVisible(d);
        if(d){
            showHasil.setHasil();
        }
    }

    public void addSoalView(Boolean b){
        addSoal.setVisible(b);
        if(b){
            addSoal.setLayoutStatus();
        }
    }
}
