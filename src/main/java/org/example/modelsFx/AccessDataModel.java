package org.example.modelsFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.database.dao.AccessDataDao;
import org.example.database.models.AccessData;
import org.example.tools.TransformAccessData;

import java.util.List;

public class AccessDataModel {

    private ObjectProperty<AccessDataFX> accessDataFXProperty = new SimpleObjectProperty<>(new AccessDataFX());
    private ObservableList<AccessDataFX> accessDataFXObservableList = FXCollections.observableArrayList();

    public void saveAccessDataInDB() {
        try {
            AccessData accessData = TransformAccessData.transformToAccessData(this.getAccessDataFXProperty());
            AccessDataDao accessDataDao = new AccessDataDao();
            accessDataDao.createAccess(accessData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
    }

    public void updateAccess(AccessDataFX accessDataFX) {
            AccessDataDao accessDataDao = new AccessDataDao();
            accessDataDao.updateById(accessDataFX.getId(), accessDataFX.getObject(), accessDataFX.getLogin(), accessDataFX.getPassword(), accessDataFX.getNote());
            init();
    }

    public void deleteAccess(AccessDataFX accessDataFX){
        AccessDataDao accessDataDao = new AccessDataDao();
        accessDataDao.deleteById(accessDataFX.getId());
        init();
    }

    public void init() {
        AccessDataDao accessDataDao = new AccessDataDao();
        List<AccessData> accessDataList = accessDataDao.querryForAll();
        this.accessDataFXObservableList.clear();
        accessDataList.forEach(x -> {
            AccessDataFX accessDataFX = TransformAccessData.transformToAccessDataFX(x);
            this.accessDataFXObservableList.add(accessDataFX);
        });
    }


    public ObservableList<AccessDataFX> getAccessDataFXObservableList() {
        return accessDataFXObservableList;
    }

    public void setAccessDataFXObservableList(ObservableList<AccessDataFX> accessDataFXObservableList) {
        this.accessDataFXObservableList = accessDataFXObservableList;
    }

    public AccessDataFX getAccessDataFXProperty() {
        return accessDataFXProperty.get();
    }

    public ObjectProperty<AccessDataFX> accessDataFXPropertyProperty() {
        return accessDataFXProperty;
    }

    public void setAccessDataFXProperty(AccessDataFX accessDataFXProperty) {
        this.accessDataFXProperty.set(accessDataFXProperty);
    }


}
