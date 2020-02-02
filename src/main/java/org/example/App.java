package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.database.models.User;
import org.example.database.tools.HibernateUtil;
import org.example.tools.toolFxml;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
//    private static final int COUNT_LIMIT = 50000;
//
//    private static int stepCount = 1;
//    public static String STEP() {
//        return stepCount++ + ". ";
//    }

    @Override
    public void init() throws Exception {
        super.init();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t;
            t = session.beginTransaction();
            User us = session.get(User.class, 1);
            t.commit();
            session.close();
        } catch(HibernateException ex) {

        }
//        for (int i = 0; i < COUNT_LIMIT; i++) {
//            double progress = (100 * i) / COUNT_LIMIT;
//            //notifyPreloader(this, new Preloader.ProgressNotification(progress));
//            notifyPreloader(new Preloader.ProgressNotification(progress));
//        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane borderPane = toolFxml.fxmlLoader("fxml/mainPanel.fxml");
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("App");
        primaryStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(  "fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", MyPreloader.class.getCanonicalName());
        Application.launch(App.class, args);
    }

}