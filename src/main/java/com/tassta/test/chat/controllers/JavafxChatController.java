package com.tassta.test.chat.controllers;

import com.tassta.test.chat.model.User;
import com.tassta.test.chat.model.implementation.UserListModelImp;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class JavafxChatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> contactsTabView;

    @FXML
    private TableColumn<User, Boolean> statusCol;

    @FXML
    private TableColumn<User, ImageView> avatarCol;

    @FXML
    private TableColumn<User, String> nameCol;

    @FXML
    private TableColumn<User, Boolean> newMessColl;

    @FXML
    private TextArea sendMessHistort;

    @FXML
    private Label communicationWithUserName;

    @FXML
    private TextArea sendMessTxtAr;

    @FXML
    private Button sendMessBtn;

    @FXML
    private Label authorizedUserNameLab;

    @FXML
    private ImageView authorizedUserIconImg;

    //User logged in with username and password
    private User authorizedUser;

    @FXML
    void initialize() {
        //test login user
        authorizedUser = UserListModelImp.getUserListModelImpInstance().getUser(0);

        userTableInit();
    }

    private void userTableInit() {

        //Установка статуса (онлайн/офлайн)
        statusCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> param) {

                return new SimpleBooleanProperty(param.getValue().isOnline());
            }
        });

        statusCol.setCellFactory(new Callback<TableColumn<User, Boolean>,
                TableCell<User, Boolean>>() {
            @Override
            public TableCell<User, Boolean> call(TableColumn<User, Boolean> p) {
                CheckBoxTableCell<User, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //Установка аватара
        avatarCol.setCellValueFactory(c -> {
            User user = c.getValue();
            return new SimpleObjectProperty<>(new ImageView(user.getIcon()));
        });

        //Установка имени
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setStyle( "-fx-alignment: CENTER;");

        //Установка статуса нового сообщения
        newMessColl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> param) {

                return new SimpleBooleanProperty(param.getValue());
            }
        });

        newMessColl.setCellFactory(new Callback<TableColumn<User, Boolean>,
                TableCell<User, Boolean>>() {
            @Override
            public TableCell<User, Boolean> call(TableColumn<User, Boolean> p) {
                CheckBoxTableCell<User, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        contactsTabView.setItems(UserListModelImp.getUserListModelImpInstance().getUserList());
    }
}
