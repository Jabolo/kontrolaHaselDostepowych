package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.modelsFX.UserModel;
import org.example.modelsFx.ListUsersModel;
import org.example.modelsFx.UserFX;

public class usersPanelController {

    public usersPanelController() {
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
    private TableColumn<UserFX, String> statusCol;
    @FXML
    private TableColumn<UserFX, UserFX> editCol;

    private UserModel userModel;
    private ListUsersModel listUsersModel;

    @FXML
    private void initialize() {
        this.userModel = new UserModel();
        try{
            this.userModel.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bindings();
        bindingTableView();

        System.out.println("usersPaelInitialize");
        this.listUsersModel = new ListUsersModel();
        try {
            this.listUsersModel.initUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bindingTableView() {
        this.usersTableView.setItems(this.userModel.getUserFXObservableList());
        this.nameCol.setCellValueFactory(cellData -> cellData.getValue().uz_NameProperty());
        this.surnameCol.setCellValueFactory(cellData -> cellData.getValue().uz_SurnameProperty());
        this.loginCol.setCellValueFactory(cellData -> cellData.getValue().uz_LoginProperty());
        this.passwordCol.setCellValueFactory(cellData -> cellData.getValue().uz_PasswordProperty());
    }

    private void bindings() {
        this.userModel.userFXObjectPropertyProperty().get().uz_NameProperty().bind(this.txtName.textProperty());
        this.userModel.userFXObjectPropertyProperty().get().uz_SurnameProperty().bind(this.txtSurname.textProperty());
        this.btnAddUser.disableProperty().bind(this.txtLogin.textProperty().isEmpty());
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
}
