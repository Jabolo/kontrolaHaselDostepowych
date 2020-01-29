package org.example.modelsFx;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.database.dao.UserDao;
import org.example.database.models.User;
import org.example.tools.TransformUser;

import java.util.List;

public class UserModel {


    private ObjectProperty<UserFX> UserFXObjectProperty = new SimpleObjectProperty<>(new UserFX());
    private ObservableList<UserFX> UserFXObservableList = FXCollections.observableArrayList();

    public void saveUserInDataBase() {
        User user = TransformUser.transformToUser(this.getUserFXObjectProperty());
        UserDao userDao = new UserDao();
        userDao.createUser(user);
        init();
    }

    public void updateUser(UserFX userFX) {
        UserDao userDao = new UserDao();
        userDao.updateById(userFX.getUz_id(), userFX.getUz_Login(), userFX.getUz_Name(), userFX.getUz_Password(), userFX.getUz_Surname());
        init();
    }

    public void deleteUser(UserFX userFX) {
        UserDao userDao = new UserDao();
        userDao.deleteById(userFX.getUz_id());
        init();
    }

    public void init(){
        UserDao userDao = new UserDao();
        List<User> userList = userDao.querryForAll();
        this.UserFXObservableList.clear();
        userList.forEach(x -> {
            UserFX userFX = TransformUser.transformToUserFx(x);
            this.UserFXObservableList.add(userFX);
        });
    }



    public UserFX getUserFXObjectProperty() {
        return UserFXObjectProperty.get();
    }

    public ObjectProperty<UserFX> userFXObjectPropertyProperty() {
        return UserFXObjectProperty;
    }

    public void setUserFXObjectProperty(UserFX userFXObjectProperty) {
        this.UserFXObjectProperty.set(userFXObjectProperty);
    }

    public ObservableList<UserFX> getUserFXObservableList() {
        return UserFXObservableList;
    }

    public void setUserFXObservableList(ObservableList<UserFX> userFXObservableList) {
        UserFXObservableList = userFXObservableList;
    }
}
