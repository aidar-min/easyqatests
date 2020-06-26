package com.easyqa.qa.page.util;

public class UserData {
    private String userEmail;
    private String userPassword;

    public UserData(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;

    }
}