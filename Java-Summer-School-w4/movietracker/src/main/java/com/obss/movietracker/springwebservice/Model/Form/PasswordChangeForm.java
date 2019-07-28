package com.obss.movietracker.springwebservice.Model.Form;

public class PasswordChangeForm {
    private String username;
    private String password;
    private String newPassword;

    @Override
    public String toString() {
        return "PasswordChangeForm{" +
                "email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
