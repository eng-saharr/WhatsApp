package com.example.mya.data.model;

public class UserCalls {
    private int userImage;
    public String userName;
    private String callTime;

    public UserCalls(int userImage, String userName, String callTime) {
        this.userImage = userImage;
        this.userName = userName;
        this.callTime = callTime;
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

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }
}
