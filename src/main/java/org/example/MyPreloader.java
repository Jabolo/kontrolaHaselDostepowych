package org.example;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MyPreloader extends Preloader {
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;

    private Stage preloaderStage;
    private Scene scene;
    private Label progress;

    public MyPreloader() {
        super();
    }

    @Override
    public void init() throws Exception {
        super.init();
        Platform.runLater(() ->{
            Label title = new Label("Loading, please wait...");
            title.setTextAlignment(TextAlignment.CENTER);
            progress = new Label("");
            VBox root = new VBox(title, progress);
            root.setAlignment(Pos.CENTER);
            scene = new Scene(root, WIDTH, HEIGHT);
        });
    }
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start preloader");
        this.preloaderStage = stage;
        preloaderStage.setScene(scene);
        preloaderStage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        super.handleStateChangeNotification(info);
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                // Called after MyPreloader#start is called.
                break;
            case BEFORE_INIT:
                // Called before MyApplication#init is called.
                break;
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                preloaderStage.hide();
                break;
        }
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        super.handleApplicationNotification(info);
        if (info instanceof ProgressNotification) {
            //progress.setText(((ProgressNotification) info).getProgress() + "%");
        }
    }
}
