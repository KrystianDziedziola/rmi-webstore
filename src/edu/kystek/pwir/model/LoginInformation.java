package edu.kystek.pwir.model;

import java.io.Serializable;

public class LoginInformation implements Serializable {

    private String login;
    private String password;

    public LoginInformation(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInformation{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginInformation that = (LoginInformation) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;

    }

}
