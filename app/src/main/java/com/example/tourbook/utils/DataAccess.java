package com.example.tourbook.utils;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tourbook.model.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class DataAccess {
    public static List<User> users = new ArrayList<>();

    public static void getAllUsers(final Context context){
        String url = "http://192.168.56.1/androidwebservice/getAllUsers.php";
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject user = response.getJSONObject(i);

                            Toast.makeText(context, user.getString("username"), Toast.LENGTH_SHORT).show();

                            users.add(Utils.parseJsonToUser(user));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonArrayRequest);
    }

    //this method violate dependency principle
    public static User getUser(Context context, String username) {
        String url = "http://192.168.56.1/androidwebservice/getUser.php";
        final User[] user = {null};

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        user[0] = Utils.parseJsonToUser(new JSONObject(response));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    System.out.println("DATA: " + user[0].getFullName());
                },
                error -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        ) {
            @Override
            protected Map<String, String> getParams() {
                return Collections.singletonMap("username", username);
            }
        };

        requestQueue.add(stringRequest);

        //why null?
        System.out.println("DATA: " + user[0].getFullName());
        return user[0];
    }

    public static User getUser(String username) {
        for (User user :
                users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
