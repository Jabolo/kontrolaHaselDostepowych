package org.example.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.modelsFx.UserFX;
import org.example.modelsFx.UserModel;

public class UsersPanelController {

    public UsersPanelController() {
    }

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnAddUser;


    @FXML
    private TableView<UserFX> usersTableView;
    @FXML
    private TableColumn<UserFX, String> nameCol;
    @FXML
    private TableColumn<UserFX, String> surnameCol;
    @FXML
    private TableColumn<UserFX, String> loginCol;
    @FXML
    private TableColumn<UserFX, String> passwordCol;
    @FXML
    private TableColumn<UserFX, Boolean> statusCol;
    @FXML
    private TableColumn<UserFX, UserFX> deleteCol;
    @FXML
    private TableColumn<UserFX, UserFX> updateCol;

    private UserModel userModel;

    @FXML
    private void initialize() {
        this.userModel = new UserModel();
        this.userModel.init();
        binding();
    }

    private void binding() {
        bindingTableView();
        bindTxtFields();
        bindButton();
    }

    private void bindTxtFields() {
        this.userModel.userFXObjectPropertyProperty().get().uz_NameProperty().bind(this.txtName.textProperty());
        this.userModel.userFXObjectPropertyProperty().get().uz_SurnameProperty().bind(this.txtSurname.textProperty());
        this.userModel.userFXObjectPropertyProperty().get().uz_PasswordProperty().bind(this.txtPassword.textProperty());
        this.userModel.userFXObjectPropertyProperty().get().uz_LoginProperty().bind(this.txtLogin.textProperty());
    }

    private void bindingTableView() {
        this.usersTableView.setItems(this.userModel.getUserFXObservableList());
        this.nameCol.setCellValueFactory(cellData -> cellData.getValue().uz_NameProperty());
        this.surnameCol.setCellValueFactory(cellData -> cellData.getValue().uz_SurnameProperty());
        this.loginCol.setCellValueFactory(cellData -> cellData.getValue().uz_LoginProperty());
        this.passwordCol.setCellValueFactory(cellData -> cellData.getValue().uz_PasswordProperty());
        this.deleteCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.deleteCol.setCellFactory(param -> new TableCell<>(){
            Button button = new Button("Usuń");
            @Override
            protected void updateItem(UserFX userFX, boolean empty) {
                super.updateItem(userFX, empty);
                //tutaj buduje komorke

                if (!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        userModel.deleteUser(userFX);
                    });
                }
                else{
                    setGraphic(null);
                    return;
                }
            }
        });

        this.updateCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.updateCol.setCellFactory(param -> new TableCell<>(){
            Button button = new Button("Aktualizuj");

            @Override
            protected void updateItem(UserFX userFX, boolean empty) {
                super.updateItem(userFX, empty);
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        userModel.updateUser(userFX);
                    });
                }
                else {
                    setGraphic(null);
                    return;
                }
            }
        });

        this.statusCol.setCellValueFactory(cellData -> cellData.getValue().uz_StatusProperty());
        this.statusCol.setCellFactory(param -> new TableCell<>(){
            @Override
            protected void updateItem(Boolean s, boolean b) {
                super.updateItem(s, b);
                setText(b ? null: s.booleanValue() ? "aktywny" : "zablokowany");
            }
        });
        setCellEditable();
    }

    private void setCellEditable() {
        this.loginCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.loginCol.setOnEditCommit(e -> {
            this.usersTableView.getItems().get(e.getTablePosition().getRow()).setUz_Login(e.getNewValue());
        });

        this.passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.passwordCol.setOnEditCommit(e -> {
            this.usersTableView.getItems().get(e.getTablePosition().getRow()).setUz_Password(e.getNewValue());
        });

        this.nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nameCol.setOnEditCommit(e -> {
            this.usersTableView.getItems().get(e.getTablePosition().getRow()).setUz_Name(e.getNewValue());
        });

        this.surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameCol.setOnEditCommit(e -> {
            this.usersTableView.getItems().get(e.getTablePosition().getRow()).setUz_Surname(e.getNewValue());
        });
    }

    public void addUserAction(ActionEvent actionEvent) {
        try {
            this.userModel.saveUserInDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.txtName.clear();
        this.txtSurname.clear();
        this.txtLogin.clear();
        this.txtPassword.clear();
    }

    public void bindButton() {
        btnAddUser.disableProperty()
                .bind(txtLogin.textProperty().isEmpty().or(txtPassword.textProperty().isEmpty())
                        .or(txtName.textProperty().isEmpty()).or(txtSurname.textProperty().isEmpty()));
    }
}
