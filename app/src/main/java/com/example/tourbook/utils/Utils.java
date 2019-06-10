package com.example.tourbook.utils;

import android.content.Context;
import com.example.tourbook.model.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Utils {
    public static User parseJsonToUser(JSONObject user){
        int id = 0;
        String fullname = null, email = null, username = null, password = null, gender = null, birthday = null;

        try {
            id = user.getInt("id");
             fullname = user.getString("fullname");
             email = user.getString("email");
             username = user.getString("username");
             password = user.getString("password");
             gender = user.getString("gender");
             birthday = user.getString("birthday");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new User(id, fullname, email, username, password, gender, birthday);
    }

    //this way is not optimize, we should send server username and password then server response the result
    public static boolean verifyUser(Context context, String username, String password) {
        List<User> users = DataAccess.users;

        for (int i = 0; i < DataAccess.users.size(); i++){
            if (users.get(i).getUsername().equals(username)
                    && users.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
