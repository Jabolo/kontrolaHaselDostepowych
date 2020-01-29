package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.example.tools.toolFxml;

public class MainPanelController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize(){
        System.out.println("MainPaneInitialize");
    }

    @FXML
    void selectedAccessData(ActionEvent event) { this.setCenter("fxml/accessDataPanel.fxml"); }

    @FXML
    void selectedUsers(ActionEvent event) {
        this.setCenter("fxml/usersPanel.fxml");
    }

    public void setCenter(String fxmlPath){
        borderPane.setCenter(toolFxml.fxmlLoader(fxmlPath));
    }

}
