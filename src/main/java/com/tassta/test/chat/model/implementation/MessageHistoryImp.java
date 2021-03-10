package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.Message;
import com.tassta.test.chat.model.MessageHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;


public class MessageHistoryImp implements MessageHistory {

    private ObservableList<Message> messageObservableList = FXCollections.observableList(new LinkedList<>());

    @Override
    public ObservableList<Message> getMessageList() {
        return messageObservableList;
    }

    public void putMessInMessHistory(Message message) {
        messageObservableList.add(message);
    }
}
