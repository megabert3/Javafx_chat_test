package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.Message;
import com.tassta.test.chat.model.MessageHistory;
import com.tassta.test.chat.model.User;
import javafx.scene.image.Image;

public class UserImp implements User {

    private static final String DEFAULT_IMAGE_PATH = "image/user_100px.png";
    private MessageHistoryModelImpl messageHistoryModel = new MessageHistoryModelImpl();

    private String name;
    private int id;
    private Image icon;
    private boolean online;

    public UserImp(String name, int id) {
        this.name = name;
        this.id = id;
        this.icon = new Image(DEFAULT_IMAGE_PATH);
    }

    public MessageHistory getMessageHistoryWithUser(User user) {
        return messageHistoryModel.getMessageHistory(user);
    }

    public void addMessageInHistoryWithUser(User user, Message message) {
        MessageHistory messageHistory = getMessageHistoryWithUser(user);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isOnline() {
        return online;
    }

    @Override
    public Image getIcon() {
        return icon;
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
