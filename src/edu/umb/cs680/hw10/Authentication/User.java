package edu.umb.cs680.hw10.Authentication;

public class User {
    private int id;
    private String name, username;

    public User(int id, String name, String username){
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public String getName(){
        return this.name;
    }

    public String getUsername(){
        return this.username;
    }

    public int getId(){
        return this.id;
    }
}
