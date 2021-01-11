package com.CBTSystem.DataModel;

public class UserDataModel {
    private final String username;
    private final String password;
    private final String role;
    public UserDataModel(String username, String password,String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUserUsername() {
        return username;
    }

    public String getUserPassword() {
        return password;
    }

    public String getUserRole(){return role;}
}
