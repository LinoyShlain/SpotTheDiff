package com.example.spotthediff;

import android.widget.EditText;

public class Usermodel {
    private String name;
    private String password;
    private int bestscore;
    private int lastscore;
    private int level;


public Usermodel(String name, String password, int bestscore, int lastscore, int level){
    this.name = name;
    this.password = password;
    this.bestscore = bestscore;
    this.lastscore = lastscore;
    this.level = level;
}

    public Usermodel(String userName)  // this is a guest
    {
        this.name = userName;
        this.password = "0000";
        this.bestscore = 0;
        this.lastscore = 0;
        this.level = 0;
    }

    public Usermodel(String userName, String password)  // this is a guest
    {
        this.name = userName;
        this.password = password;
        this.bestscore = 0;
        this.lastscore = 0;
        this.level = 0;
    }


public String getName() {
    return name;
}

public void setName() {
    this.name = name;
}

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public int getBestscore() {
        return bestscore;
    }

    public void setBestscore() {
        this.bestscore = bestscore;
    }

    public int getLastscore() {
        return lastscore;
    }

    public void setLastscore() {
        this.lastscore = lastscore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        this.level = level;
    }

}

