package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.User;
import javafx.scene.image.Image;

public class UserImp implements User {

    private String name;
    private int id;
    private Image icon;
    private boolean online;

    public UserImp(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public Image getIcon() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}