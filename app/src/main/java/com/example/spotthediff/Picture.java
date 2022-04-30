package com.example.spotthediff;

public class Picture {
private String name;
private String difference1;
    private String difference2;
    private String difference3;
    private String theme;
    private String type;

    public Picture (String name, String difference1, String difference2, String difference3, String theme, String type) {
        this.name = name;
        this.difference1 = difference1;
        this.difference2 = difference2;
        this.difference3 = difference3;
        this.theme = theme;
        this.type = type; // original
    }

    public Picture (String name, String difference2, String difference3, String theme, String type) {
        this.name = name;
        this.difference1 = "";
        this.difference2 = difference2;
        this.difference3 = difference3;
        this.theme = theme;
        this.type = type; // copy
    }

    public Picture (String name, String difference2,  String theme, String type) {
        this.name = name;
        this.difference1 = "";
        this.difference2 = difference2;
        this.difference3 = "";
        this.theme = theme;
        this.type = type; // copy
    }
    public Picture (String name, String theme, String type) {
        this.name = name;
        this.difference1 = "";
        this.difference2 = "";
        this.difference3 = "";
        this.theme = theme;
        this.type = type; // copy
    }


    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDifference1() {
        return difference1;
    }

    public void setDifference1() {
        this.difference1 = difference1;
    }

    public String getDifference2() {
        return difference2;
    }

    public void setDifference2() {
        this.difference2 = difference2;
    }

    public String getDifference3() {
        return difference3;
    }

    public void setDifference3() {
        this.difference3 = difference3;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme() {
        this.theme = theme;
    }

}








