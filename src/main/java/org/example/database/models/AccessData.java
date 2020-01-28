package org.example.database.models;

import javax.persistence.*;
import java.util.stream.BaseStream;

@Entity
        @Table(name = "NEO1012_DaneDostepoweBackUp")
public class AccessData implements BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dd_id")
    private int id;
    @Column(name = "dd_Login")
    private String login;
    @Column(name = "dd_Haslo")
    private String password;
    @Column(name = "dd_Notatka")
    private String note;
    @Column(name = "dd_Obiekt")
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public AccessData(){

    }
//    public AccessData(String txtObjectText, String txtLoginText, String txtPasswordText, String txtNote){
//        this.login = txtLoginText;
//        this.password = txtPasswordText;
//        this.note = txtNote;
//        this.object = txtObjectText;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
