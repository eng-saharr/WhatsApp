package com.example.mya.data.model;

public class UserStatusModel {
    private int userImage;
    private String userName;
    private String statusTime;

    public UserStatusModel(int userImage, String userName, String statusTime) {
        this.userImage = userImage;
        this.userName = userName;
        this.statusTime = statusTime;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }
}
