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
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
//        scene = new Scene(loadFXML("mainPanel"));
//        stage.setScene(scene);
//        stage.show();
        Pane borderPane = toolFxml.fxmlLoader("fxml/mainPanel.fxml");
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kom");
        primaryStage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(  "fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        String hostName = "localhost"; // update me
//        String dbName = "NEO1012_Kontrola"; // update me
//        String user = "user"; // update me
//        String password = "password"; // update me
//        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s", hostName, dbName, user, password);
//        String connectionUrl = "jdbc:sqlserver://localhost;database=NEO1012_Kontrola;user=user;password=password";
//        String databaseURL = "jdbc:sqlserver://localhost:1433/NEO1012_Kontrola?user=sa";
//        try {
//            // Load SQL Server JDBC driver and establish connection.
//            System.out.print("Connecting to SQL Server ... ");
//            try (Connection connection = DriverManager.getConnection(url)) {
//                System.out.println("Done.");
//            }
//        } catch (Exception e) {
//            System.out.println();
//            e.printStackTrace();
//        }

//        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
//        Student student1 = new Student("John", "Cena", "john@javaguides.com");
        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the student objects
//            session.save(student);
//            session.save(student1);
//            session.
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

//            User uze = session.get(User.class, 1);
//            if(uze != null) System.out.println(uze.getUz_Name());
//            else
//                System.out.println("sasasasa");

//            Query querry = session.createQuery("from User where uz_id=1");
//            List<?> list = querry.list();
//            User uzer = (User)list.get(0);
//            System.out.println(uzer.toString());

            List<User> users = session.createQuery("from User ", User.class).list();
            for (User uz: users
                 ) {
                System.out.println(uz.getUz_Name());
                uz.toString();
            }
            //users.forEach(uz - > System.out.println(uz.getUz_Imie()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        launch(args);
    }

}