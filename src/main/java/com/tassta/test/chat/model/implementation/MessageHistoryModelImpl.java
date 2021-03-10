package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.MessageHistory;
import com.tassta.test.chat.model.MessageHistoryModel;
import com.tassta.test.chat.model.User;

import java.util.HashMap;

public class MessageHistoryModelImpl implements MessageHistoryModel {

    private HashMap<User, MessageHistory> userMessageHistoryImpHashMap = new HashMap<>();

    @Override
    public MessageHistory getMessageHistory(User user) {
        return userMessageHistoryImpHashMap.get(user);
    }
}
