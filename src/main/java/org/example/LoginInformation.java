package org.example;

public class LoginInformation {
    private String email = "";
    private String password = "";
    LoginInformation(){
        email = this.email;
        password = this.password;
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
}
