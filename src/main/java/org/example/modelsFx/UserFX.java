package org.example.modelsFx;

import javafx.beans.property.*;

public class UserFX {

    private IntegerProperty uz_id = new SimpleIntegerProperty();
    private StringProperty uz_Login = new SimpleStringProperty();
    private StringProperty uz_Password = new SimpleStringProperty();
    private StringProperty uz_Surname = new SimpleStringProperty();
    private StringProperty uz_Name = new SimpleStringProperty();
    private BooleanProperty uz_Status = new SimpleBooleanProperty();
    private StringProperty uz_IV = new SimpleStringProperty();

    public int getUz_id() {
        return uz_id.get();
    }

    public IntegerProperty uz_idProperty() {
        return uz_id;
    }

    public void setUz_id(int uz_id) {
        this.uz_id.set(uz_id);
    }

    public String getUz_Login() {
        return uz_Login.get();
    }

    public StringProperty uz_LoginProperty() {
        return uz_Login;
    }

    public void setUz_Login(String uz_Login) {
        this.uz_Login.set(uz_Login);
    }

    public String getUz_Password() {
        return uz_Password.get();
    }

    public StringProperty uz_PasswordProperty() {
        return uz_Password;
    }

    public void setUz_Password(String uz_Password) {
        this.uz_Password.set(uz_Password);
    }

    public String getUz_Surname() {
        return uz_Surname.get();
    }

    public StringProperty uz_SurnameProperty() {
        return uz_Surname;
    }

    public void setUz_Surname(String uz_Surname) {
        this.uz_Surname.set(uz_Surname);
    }

    public String getUz_Name() {
        return uz_Name.get();
    }

    public StringProperty uz_NameProperty() {
        return uz_Name;
    }

    public void setUz_Name(String uz_Name) {
        this.uz_Name.set(uz_Name);
    }

    public boolean isUz_Status() {
        return uz_Status.get();
    }

    public BooleanProperty uz_StatusProperty() {
        return uz_Status;
    }

    public void setUz_Status(boolean uz_Status) {
        this.uz_Status.set(uz_Status);
    }

    public String getUz_IV() {
        return uz_IV.get();
    }

    public StringProperty uz_IVProperty() {
        return uz_IV;
    }

    public void setUz_IV(String uz_IV) {
        this.uz_IV.set(uz_IV);
    }

}
