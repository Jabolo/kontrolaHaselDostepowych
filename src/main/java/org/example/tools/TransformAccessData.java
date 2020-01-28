package org.example.tools;

import org.example.database.models.AccessData;
import org.example.modelsFx.AccessDataFX;

public class TransformAccessData {
    public static AccessData transformToAccessData(AccessDataFX accessDataFX){
        AccessData accessData = new AccessData();
        accessData.setId(accessDataFX.getId());
        accessData.setLogin(accessDataFX.getLogin());
        accessData.setPassword(accessDataFX.getPassword());
        accessData.setNote(accessDataFX.getNote());
        accessData.setObject(accessDataFX.getObject());
        return accessData;
    }

    public static AccessDataFX transformToAccessDataFX(AccessData accessData){
        AccessDataFX accessDataFX = new AccessDataFX();
        accessDataFX.setId(accessData.getId());
        accessDataFX.setLogin(accessData.getLogin());
        accessDataFX.setPassword(accessData.getPassword());
        accessDataFX.setNote(accessData.getNote());
        accessDataFX.setObject(accessData.getObject());
        return  accessDataFX;
    }
}
