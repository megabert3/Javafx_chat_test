package com.tassta.test.chat.model.noimpl;

import com.tassta.test.chat.model.Message;
import com.tassta.test.chat.model.User;
import com.tassta.test.chat.model.UserStateChangeHandler;

import java.util.function.Consumer;

public class IoManagerImp implements IoManger {

    @Override
    public void sendMessage(User receiver, String text) throws Exception {

    }

    @Override
    public void setRecieveMessageHandler(Consumer<Message> handler) {

    }

    @Override
    public void setUserStateChangeHandler(UserStateChangeHandler handler) {

    }

    @Override
    public void setUserAddedHandler(Consumer<User> handler) {

    }

    @Override
    public void setUserRemovedHandler(int userId) {

    }
}
