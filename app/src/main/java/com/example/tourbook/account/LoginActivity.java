package com.example.tourbook.account;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.tourbook.MainActivity;
import com.example.tourbook.R;
import com.example.tourbook.model.User;
import com.example.tourbook.utils.DataAccess;
import com.example.tourbook.utils.Utils;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    private TextView register;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        DataAccess.getAllUsers(LoginActivity.this);
        //DataAccess.getData();
//        DataAccess.getUser(LoginActivity.this, "anvh2");

//        System.out.println("USER DATA: " + DataAccess.getUser(LoginActivity.this, "anvh2").getFullName());

        login.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this)
                    .setCancelable(true);

            if (username.length() == 0 || password.length() == 0) {
                dialog.setMessage("Please type username and password").show();
            } else {
                if (Utils.verifyUser(LoginActivity.this, username.getText().toString(), password.getText().toString())){
                    user = DataAccess.getUser(username.getText().toString());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class)
                            .putExtra("user", user));
                } else {
                    dialog.setMessage("Your user name and password is incorrect").show();
                }
            }
        });

        register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void init() {
        login = findViewById(R.id.btn_login);
        username = findViewById(R.id.edt_username);
        password =  findViewById(R.id.edt_pass);
        register = findViewById(R.id.tv_register);
    }
}
