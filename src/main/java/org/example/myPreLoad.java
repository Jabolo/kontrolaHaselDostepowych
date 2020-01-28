package org.example;

import javafx.application.Preloader;
import javafx.stage.Stage;

public class myPreLoad extends Preloader {
    @Override
    public void start(Stage stage) throws Exception {

    }

    public myPreLoad() {
        super();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        super.handleStateChangeNotification(stateChangeNotification);
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification preloaderNotification) {
        super.handleApplicationNotification(preloaderNotification);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }
}
