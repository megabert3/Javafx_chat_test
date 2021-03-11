package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.MessageHistory;
import com.tassta.test.chat.model.MessageHistoryModel;
import com.tassta.test.chat.model.User;

import java.util.HashMap;

public class MessageHistoryModelImpl implements MessageHistoryModel {

    private HashMap<User, MessageHistory> userMessageHistoryImpHashMap = new HashMap<>();

    private static MessageHistoryModelImpl messageHistoryModel;

    private MessageHistoryModelImpl () {

        for (User userHistory : UserListModelImp.getUserListModelImpInstance().getUserList()) {
            userMessageHistoryImpHashMap.put(userHistory, new MessageHistoryImp());
        }
    }

    public static MessageHistoryModel getMessageHistoryModelImplInstanse() {
        if (messageHistoryModel == null) {
            messageHistoryModel = new MessageHistoryModelImpl();
        }

        return messageHistoryModel;
    }

    @Override
    public MessageHistory getMessageHistory(User user) {
        return userMessageHistoryImpHashMap.get(user);
    }
}