package org.example.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.modelsFx.AccessDataFX;
import org.example.modelsFx.AccessDataModel;

public class AccessDataPanelController {


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
    @FXML
    private TableColumn<AccessDataFX, AccessDataFX> updateCol;
    @FXML
    private TableColumn<AccessDataFX, AccessDataFX> deleteCol;

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
        this.deleteCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue())); //zeby był obserwowalny
        this.deleteCol.setCellFactory(param -> new TableCell<AccessDataFX, AccessDataFX>(){
            Button button = new Button("Usuń");
            @Override
            protected void updateItem(AccessDataFX accessDataFX, boolean empty) {
                super.updateItem(accessDataFX, empty);
                //tutaj buduje komorke

                if (!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        accessDataModel.deleteAccess(accessDataFX);
                    });
                }
                else{
                    setGraphic(null);
                    return;
                }
            }
        });

        this.updateCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.updateCol.setCellFactory(param -> new TableCell<AccessDataFX, AccessDataFX>(){
            Button button = new Button("Aktualizuj");

            @Override
            protected void updateItem(AccessDataFX accessDataFX, boolean empty) {
                super.updateItem(accessDataFX, empty);
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        accessDataModel.updateAccess(accessDataFX);
                    });
                }
            }
        });

        setCellEditable();
    }

    private void setCellEditable() {
        this.loginCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.loginCol.setOnEditCommit(e -> {
            this.accessDataTableView.getItems().get(e.getTablePosition().getRow()).setLogin(e.getNewValue());
        });

        this.objectCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.objectCol.setOnEditCommit(e -> {
            this.accessDataTableView.getItems().get(e.getTablePosition().getRow()).setObject(e.getNewValue());
        });

        this.passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.passwordCol.setOnEditCommit(e -> {
            this.accessDataTableView.getItems().get(e.getTablePosition().getRow()).setPassword(e.getNewValue());
        });

        this.noteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.noteCol.setOnEditCommit(e -> {
            this.accessDataTableView.getItems().get(e.getTablePosition().getRow()).setNote(e.getNewValue());
        });
    }

    public void btnAddAccessDataAction(ActionEvent actionEvent) {
        try {
            this.accessDataModel.saveAccessDataInDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            this.txtLogin.clear();
            this.txtNote.clear();
            this.txtPassword.clear();
            this.txtObject.clear();
        }
    }

    public void bindButton() {
        btnAddAccessData.disableProperty()
                .bind(txtObject.textProperty().isEmpty().or(txtLogin.textProperty().isEmpty())
                .or(txtNote.textProperty().isEmpty()).or(txtPassword.textProperty().isEmpty()));
    }

}
