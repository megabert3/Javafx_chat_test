package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.Message;
import com.tassta.test.chat.model.User;

import java.util.Date;

public class MessageImp implements Message {

    private Date date;
    private String text;
    private User sender;
    private User receiver;

    public MessageImp(String text, User sender, User receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.date = new Date();
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public User getSender() {
        return sender;
    }

    @Override
    public User getReceiver() {
        return receiver;
    }
}
