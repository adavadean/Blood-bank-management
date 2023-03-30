package business;

import javax.swing.*;

public class Doctor extends User{
    private final static String username = "doctor1";
    private final static String password = "doc";

    public Doctor(){
        super(username, password);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
