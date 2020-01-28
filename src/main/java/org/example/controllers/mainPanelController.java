package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.example.tools.toolFxml;

import java.io.IOException;

public class mainPanelController {

    @FXML
    private BorderPane borderPane;
@FXML
private usersPanelController usersPanelController;

    @FXML
    private void initialize(){
        System.out.println("MainPaneInitialize");
    }

    @FXML
    void selectedAccessData(ActionEvent event) {
        System.out.println("AccessPaneSeleted");
        this.setCenter("fxml/accessDataPanel.fxml");
    }

    @FXML
    void selectedUsers(ActionEvent event) {
        this.setCenter("fxml/usersPanel.fxml");
    }

    public void setCenter(String fxmlPath){
        borderPane.setCenter(toolFxml.fxmlLoader(fxmlPath));
    }


}
