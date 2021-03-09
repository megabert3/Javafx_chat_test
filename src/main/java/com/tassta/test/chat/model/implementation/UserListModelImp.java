package com.tassta.test.chat.model.implementation;

import com.tassta.test.chat.model.User;
import com.tassta.test.chat.model.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class UserListModelImp implements UserListModel {

    private List<User> userList = new ArrayList<>();

    private static UserListModelImp userListModelImp;

    private UserListModelImp() {}

    public UserListModelImp getUserListModelImpInstance() {
        if (userListModelImp == null) {
            userListModelImp = new UserListModelImp();
        }

        return userListModelImp;
    }

    @Override
    public ObservableList<User> getUserList() {
        return FXCollections.observableList(userList);
    }
}
