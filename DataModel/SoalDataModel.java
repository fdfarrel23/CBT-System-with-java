package com.CBTSystem.DataModel;

public class SoalDataModel {
    private final String soal;
    private final String[] jawaban;
    private final String jawaban_benar;
    public SoalDataModel(String soal,String[] jawaban,String jawaban_benar){
        this.soal = soal;
        this.jawaban = jawaban;
        this.jawaban_benar = jawaban_benar;
    }

    public String getSoal() {
        return soal;
    }

    public String[] getJawaban() {
        return jawaban;
    }

    public String getJawaban_benar(){return jawaban_benar;}
}
