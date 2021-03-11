package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.User;
import com.tassta.test.chat.model.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class UserListModelImp implements UserListModel {

    private ObservableList<User> userList = FXCollections.observableList(new ArrayList<>());

    private static UserListModelImp userListModelImp;

    private UserListModelImp() {
        //Test users
        userList.add(new UserImp("ТестовыйФедот", 0));
        userList.add(new UserImp("ТестовыйАркадий", 1));
        userList.add(new UserImp("ТестовыйМихаил", 2));
        userList.add(new UserImp("ТестовыйАлександр", 3));
    }

    public static UserListModelImp getUserListModelImpInstance() {
        if (userListModelImp == null) {
            userListModelImp = new UserListModelImp();
        }

        return userListModelImp;
    }

    @Override
    public ObservableList<User> getUserList() {
        return userList;
    }

    public User getUser(User user) {
        return userList.stream().findFirst().orElse(null);
    }

    public User getUser(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
