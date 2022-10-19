package com.example.mya.data.model;

public class UserModel {
    private int userImage;
    private String userName;
    private String chatContent;

    public UserModel(int userImage,String userName,String chatContent) {
        this.userImage = userImage;
        this.userName=userName;
        this.chatContent=chatContent;
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

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }
}
