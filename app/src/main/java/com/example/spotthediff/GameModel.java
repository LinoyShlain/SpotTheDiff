package com.example.spotthediff;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameModel {

    private int picture1;
    private int picture2;
    private int level;
    private int timer;
    private int score;
    private int rightAnswer;
    private TextRB textRB;





    public GameModel(int picture1, int picture2, int level, int timer,  int rightAnswer, TextRB textRB) {
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.level = level;
        this.timer = timer;
        this.score = 0;
        this.rightAnswer = rightAnswer;
        this.textRB = textRB;
    }



    public GameModel (int picture1, int picture2,TextRB textRB) {
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.level = 1;
        this.timer = 1;
        this.rightAnswer = 1;

    }

    public GameModel (int picture1, int picture2, int level, int timer, int rightAnswer) {
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.level = level;
        this.timer = timer;
        this.score = 0;
        this.rightAnswer = rightAnswer;
    }




    public int getPicture1() {
        return this.picture1;
    }

    public void setPicture1() {
        this.picture1 = picture1;
    }

    public int getPicture2() {
        return this.picture2;
    }

    public void setPicture2() {
        this.picture2 = picture2;
    }

    public int addScore() {
        this.score += 10;
        return this.score;
    }



    public boolean pictureCompare(int rightAnswer) //
    {
        boolean result = false;
        if (this.rightAnswer == rightAnswer)
            result = true;
        return result;
    }

    public void showPictures() {

    }

    private void theRightAnswer () {

    }

}