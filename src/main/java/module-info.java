module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.base;
    requires java.persistence;
    requires java.activation;
    requires java.naming;
    requires com.microsoft.sqlserver.jdbc;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires net.bytebuddy;
    requires java.sql;
    requires org.hibernate.orm.core;

    exports org.example to javafx.graphics;
    exports org.example.database.dao;
    exports org.example.database.models;
    exports org.example.database.tools;
    exports org.example.tools;
    exports org.example.controllers;

    opens org.example;
    opens org.example.database.dao;
    opens org.example.database.models;
    opens org.example.database.tools;
    opens org.example.tools;
    opens org.example.controllers;

}