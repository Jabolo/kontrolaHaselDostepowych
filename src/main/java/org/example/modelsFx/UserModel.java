package org.example.modelsFX;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.database.dao.UserDao;
import org.example.database.models.User;
import org.example.modelsFx.UserFX;
import org.example.tools.TransformUser;

import java.sql.SQLException;
import java.util.List;

public class UserModel {


    private ObjectProperty<UserFX> UserFXObjectProperty = new SimpleObjectProperty<>(new UserFX());
    private ObjectProperty<UserFX> UserFXObjectPropertyEdit = new SimpleObjectProperty<>(new UserFX());

    private ObservableList<UserFX> UserFXObservableList = FXCollections.observableArrayList();


    public void init(){
        UserDao userDao = new UserDao();
        List<User> userList = userDao.querryForAll();
        this.UserFXObservableList.clear();
        userList.forEach(x -> {
            UserFX userFX = TransformUser.transformToUserFx(x);
            this.UserFXObservableList.add(userFX);
        });
    }

    public void saveUserEditInDataBase() {
        saveOrUpdate(this.getUserFXObjectPropertyEdit());
    }
    public void saveUserInDataBase() {
        User user = TransformUser.transformToUser(this.getUserFXObjectProperty());
        UserDao userDao = new UserDao();
        userDao.createOrUpdate(user);
    }

    public void deleteUserInDataBase() {
        UserDao UserDao = new UserDao();
        //UserDao.deleteById(User.class, this.getUserFXObjectPropertyEdit().getId());
//        BookDao bookDao = new BookDao();
//        bookDao.deleteByColumnName(Book.User_ID, this.getUserFXObjectPropertyEdit().getId());
        //this.init();
    }

    private void saveOrUpdate(UserFX UserFXObjectPropertyEdit) {
        UserDao UserDao = new UserDao();
        User User = TransformUser.transformToUser(UserFXObjectPropertyEdit);
        //UserDao.creatOrUpdate(User);
        //this.init();
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

    public UserFX getUserFXObjectPropertyEdit() {
        return UserFXObjectPropertyEdit.get();
    }

    public ObjectProperty<UserFX> userFXObjectPropertyEditProperty() {
        return UserFXObjectPropertyEdit;
    }

    public void setUserFXObjectPropertyEdit(UserFX userFXObjectPropertyEdit) {
        this.UserFXObjectPropertyEdit.set(userFXObjectPropertyEdit);
    }

    public ObservableList<UserFX> getUserFXObservableList() {
        return UserFXObservableList;
    }

    public void setUserFXObservableList(ObservableList<UserFX> userFXObservableList) {
        UserFXObservableList = userFXObservableList;
    }
}
