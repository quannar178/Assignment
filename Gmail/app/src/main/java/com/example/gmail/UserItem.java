package com.example.gmail;

public class UserItem {

    private String name;
    private String time;
    private String description1;
    private String description2;
    private boolean isCheck;
    private boolean isBookmark;

    public UserItem(String name, String time, String description1, String description2, boolean isCheck) {
        this.name = name;
        this.time = time;
        this.description1 = description1;
        this.description2 = description2;
        this.isCheck = isCheck;
        isBookmark = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}

