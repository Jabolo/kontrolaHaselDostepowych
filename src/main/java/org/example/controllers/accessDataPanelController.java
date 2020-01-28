package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.modelsFx.AccessDataFX;
import org.example.modelsFx.AccessDataModel;

public class accessDataPanelController {


    @FXML
    private TextField txtObject;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtNote;
    @FXML
    private Button btnAddAccessData;
    @FXML
    private TableView<AccessDataFX> accessDataTableView;
    @FXML
    private TableColumn<AccessDataFX, String> objectCol;
    @FXML
    private TableColumn<AccessDataFX, String> loginCol;
    @FXML
    private TableColumn<AccessDataFX, String> passwordCol;
    @FXML
    private TableColumn<AccessDataFX, String> noteCol;


    private AccessDataModel accessDataModel;

    @FXML
    private void initialize() {
        this.accessDataModel = new AccessDataModel();
        this.accessDataModel.init();
        binding();
    }

    private void binding() {
        bindTxtFields();
        bindTableView();
        bindButton();
    }

    private void bindTxtFields() {
        this.accessDataModel.accessDataFXPropertyProperty().get().objectProperty().bind(this.txtObject.textProperty());
        this.accessDataModel.accessDataFXPropertyProperty().get().loginProperty().bind(this.txtLogin.textProperty());
        this.accessDataModel.accessDataFXPropertyProperty().get().passwordProperty().bind(this.txtPassword.textProperty());
        this.accessDataModel.accessDataFXPropertyProperty().get().noteProperty().bind(this.txtNote.textProperty());
    }

    private void bindTableView() {
        this.accessDataTableView.setItems(this.accessDataModel.getAccessDataFXObservableList());
        this.loginCol.setCellValueFactory(cellDAta -> cellDAta.getValue().loginProperty());
        this.objectCol.setCellValueFactory(cellDAta -> cellDAta.getValue().objectProperty());
        this.passwordCol.setCellValueFactory(cellDAta -> cellDAta.getValue().passwordProperty());
        this.noteCol.setCellValueFactory(cellDAta -> cellDAta.getValue().noteProperty());
    }

    public void btnAddAccessDataAction(ActionEvent actionEvent) {
        this.accessDataModel.saveAccessDataInDB();
    }

    public void bindButton() {
        btnAddAccessData.disableProperty()
                .bind(txtObject.textProperty().isEmpty().or(txtLogin.textProperty().isEmpty())
                .or(txtNote.textProperty().isEmpty()).or(txtPassword.textProperty().isEmpty()));
    }

}
