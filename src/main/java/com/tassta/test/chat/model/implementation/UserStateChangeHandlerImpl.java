package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.User;
import com.tassta.test.chat.model.UserStateChangeHandler;
import javafx.collections.ObservableList;

public class UserStateChangeHandlerImpl implements UserStateChangeHandler {

    @Override
    public void handle(int id, User newValue) {
        ObservableList<User> userList = UserListModelImp.getUserListModelImpInstance().getUserList();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.set(i, newValue);
            }
        }
    }
}
