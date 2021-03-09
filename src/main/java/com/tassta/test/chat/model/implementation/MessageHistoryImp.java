package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.Message;
import com.tassta.test.chat.model.MessageHistory;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class MessageHistoryImp implements MessageHistory {

    private List<Message> messageList = new ArrayList<>();

    @Override
    public ObservableList<Message> getMessageList() {
        return null;
    }
}
