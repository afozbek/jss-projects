package com.obss.movietracker.movietracker.springwebservice.Form;

public class PasswordChangeForm {
    private String email;
    private String password;
    private String newPassword;

    @Override
    public String toString() {
        return "PasswordChangeForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
