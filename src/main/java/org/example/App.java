package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.database.models.User;
import org.example.database.tools.HibernateUtil;
import org.example.tools.toolFxml;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

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
            ex.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Pane borderPane = toolFxml.fxmlLoader("fxml/mainPanel.fxml");
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", MyPreloader.class.getCanonicalName());
        Application.launch(App.class, args);
    }

}