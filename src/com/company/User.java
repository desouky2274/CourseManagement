package com.company;

public class User extends Person{
    private long id;
    private String password;

    public User(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public User() {
    }

    public User(String fName, String mName, String lName, long id, String password) {
        super(fName, mName, lName);
        this.id = id;
        this.password = password;
    }
}