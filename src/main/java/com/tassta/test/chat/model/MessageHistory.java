package com.tassta.test.chat.model;

import javafx.collections.ObservableList;

/**
 * Message history is basically a list of messages.
 */
public interface MessageHistory {
    ObservableList<Message> getMessageList();
}
