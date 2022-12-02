package edu.umb.cs680.hw10.Authentication;


public class EncryptedString {
    private String username, encryptedString;

    public EncryptedString(String username, String password){
        this.username = username;
        this.encryptedString = "<encryption>"+password+"<encryption>";
    }

    public String getEncryptedString(){
        return this.encryptedString;
    }

    public String getUsername(){
        return this.username;
    }
}

