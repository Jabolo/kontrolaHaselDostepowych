package org.example.database.models;

import javax.persistence.*;

@Entity
@Table(name = "NEO1012_Uzytkownicy")
public class User implements BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uz_id")
    private int uz_id;
    @Column(name = "uz_Login")
    private String uz_Login;
    @Column(name = "uz_Haslo")
    private String uz_Password;
    @Column(name = "uz_Nazwisko")
    private String uz_Surname;
    @Column(name = "uz_Imie")
    private String uz_Name;
    @Column(name = "uz_Status")
    private boolean uz_Status;
    @Column(name = "uz_IV")
    private String uz_IV;

    public int getUz_id() {
        return uz_id;
    }

    public void setUz_id(int uz_id) {
        this.uz_id = uz_id;
    }

    public String getUz_Login() {
        return uz_Login;
    }

    public void setUz_Login(String uz_Login) {
        this.uz_Login = uz_Login;
    }

    public String getUz_Password() {
        return uz_Password;
    }

    public void setUz_Password(String uz_Haslo) {
        this.uz_Password = uz_Haslo;
    }

    public String getUz_Surname() {
        return uz_Surname;
    }

    public void setUz_Surname(String uz_Nazwisko) {
        this.uz_Surname = uz_Nazwisko;
    }

    public String getUz_Name() {
        return uz_Name;
    }

    public void setUz_Name(String uz_Imie) {
        this.uz_Name = uz_Imie;
    }

    public boolean isUz_Status() {
        return uz_Status;
    }

    public void setUz_Status(boolean uz_Status) {
        this.uz_Status = uz_Status;
    }

    public String getUz_IV() {
        return uz_IV;
    }

    public void setUz_IV(String uz_IV) {
        this.uz_IV = uz_IV;
    }
    public User(){

    }

    public User(String uz_Login, String uz_Haslo, String uz_Name, String uz_Nazwisko){
        this.uz_Login = uz_Login;
        this.uz_Password = uz_Haslo;
        this.uz_Name = uz_Name;
        this.uz_Surname = uz_Nazwisko;
        this.uz_Status = true;
        this.uz_IV = "tH9l5JRIPRI1fGH4vKxSOlgIDT4x7UiJ";
    }

    @Override
    public String toString() {
        return "User [id=" + uz_id + ", imie=" + uz_Name + ", nazwisko="+ uz_Surname;
    }
}
