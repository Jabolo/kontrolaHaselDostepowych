package org.example.tools;

import org.example.database.models.User;
import org.example.modelsFx.UserFX;

public class TransformUser {
    public static User transformToUser(UserFX userFx){
        User user = new User();
        user.setUz_id(userFx.getUz_id());
        user.setUz_Name(userFx.getUz_Name());
        user.setUz_Surname(userFx.getUz_Surname());
        user.setUz_Login(userFx.getUz_Login());
        user.setUz_Password(userFx.getUz_Password());
        user.setUz_Status(userFx.isUz_Status());
        user.setUz_IV(userFx.getUz_IV());
        return user;
    }

    public static UserFX transformToUserFx(User user){
        UserFX userFX = new UserFX();
        userFX.setUz_id(user.getUz_id());
        userFX.setUz_Name(user.getUz_Name());
        userFX.setUz_Surname(user.getUz_Surname());
        userFX.setUz_Login(user.getUz_Login());
        userFX.setUz_Password(user.getUz_Password());
        userFX.setUz_Status(user.isUz_Status());
        userFX.setUz_IV(user.getUz_IV());
        return userFX;
    }
}
