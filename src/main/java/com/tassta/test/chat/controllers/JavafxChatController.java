package com.tassta.test.chat.controllers;

import com.tassta.test.chat.model.*;
import com.tassta.test.chat.model.implementation.MessageHistoryModelImpl;
import com.tassta.test.chat.model.implementation.MessageImp;
import com.tassta.test.chat.model.implementation.UserListModelImp;
import com.tassta.test.chat.model.implementation.UserStateChangeHandlerImpl;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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

    //New mess from user
    private Tooltip newMessTLTp = new Tooltip();

    @FXML
    void initialize() {
        //test login user
        authorizedUser = UserListModelImp.getUserListModelImpInstance().getUser(0);
        userTableInit();
        initSendBtn();
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

        //Установка действия при смене пользователя для общения
        contactsTabView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user, User newValue) {
                if (newValue != null) {
                    //Устанавливаю имя с кем общаюсь
                    communicationWithUserName.setText(newValue.getName());

                    //Восстанавливаю историю сообщений
                    MessageHistory messageHistory = MessageHistoryModelImpl.getMessageHistoryModelImplInstanse().getMessageHistory(newValue);

                    if (messageHistory != null) {
                        StringBuilder stringBuilder = new StringBuilder();

                        for (Message message : messageHistory.getMessageList()) {
                            stringBuilder.append(parseMessInStrLineMess(message));
                        }

                        sendMessHistort.setText(stringBuilder.toString());
                    }

                    //По идее тут должно быть добавление нового объекта MessageHistory
                } else {

                }
            }
        });

        contactsTabView.setItems(UserListModelImp.getUserListModelImpInstance().getUserList());
    }

    //Действие при нажатии на кнопку отправить
    private void initSendBtn() {
        sendMessBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                User receiver = contactsTabView.getSelectionModel().getSelectedItem();

                //Получаю истопию сообщений с выбранным пользователем
                MessageHistory messageHistory = MessageHistoryModelImpl.getMessageHistoryModelImplInstanse().getMessageHistory(receiver);

                Message message = new MessageImp(sendMessTxtAr.getText(), authorizedUser, receiver);
                messageHistory.getMessageList().add(message);

                sendMessHistort.appendText(parseMessInStrLineMess(message));
                sendMessTxtAr.clear();
            }
        });
    }

    private String parseMessInStrLineMess(Message message) {
        return message.getDate() + "  " +
                message.getSender().getName() + ": " +
                message.getText() + "\n";
    }
}
