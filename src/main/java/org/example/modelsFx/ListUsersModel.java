package org.example.modelsFx;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.database.dao.UserDao;
import org.example.database.models.User;
import org.example.modelsFx.UserFX;
import org.example.tools.TransformUser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUsersModel {
    private ObservableList<UserFX> userFXObservableList = FXCollections.observableArrayList();

    private ObjectProperty<UserFX> userFXObjectProperty = new SimpleObjectProperty<>(new UserFX());

    private List<UserFX> userFXList = new ArrayList<>();

    public void initUsers() {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.querryForAll();
        System.out.println("Lista z listUsersModel");
        for (User uz: userList
        ) {
            System.out.println(uz.getUz_Name());
            uz.toString();
        }
        this.userFXList.clear();
        userList.forEach(userx -> {
            this.userFXList.add(TransformUser.transformToUserFx(userx));
        });
        this.userFXObservableList.setAll(userFXList);
    }

//    private Predicate<UserFX> userFXPredicate(){
//        return  userFX -> userFX.g
//    }
}
