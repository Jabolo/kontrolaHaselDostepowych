package org.example.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import org.example.App;

import java.util.ResourceBundle;

public class toolFxml {
    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));
        //loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
            toolDialogs.errorDialog(e.getMessage());
        }
        return null;
    }

    public static FXMLLoader getLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(toolFxml.class.getResource(fxmlPath));
        //loader.setResources(getResourceBundle());
        return loader;
    }
}
