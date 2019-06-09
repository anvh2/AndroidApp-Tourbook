package com.example.tourbook.account;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.tourbook.MainActivity;
import com.example.tourbook.R;
import com.example.tourbook.utils.DataAccess;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this)
                        .setCancelable(true);

                if (username.length() == 0 || password.length() == 0) {
                    dialog.setMessage("Please type username and password").show();
                } else {
                    if (DataAccess.verifyUser(username.getText().toString(), password.getText().toString())){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        dialog.setMessage("Your user name and password is incorrect").show();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void init() {
        login = findViewById(R.id.btn_login);
        username = findViewById(R.id.edt_username);
        password =  findViewById(R.id.edt_pass);
        register = findViewById(R.id.tv_register);
    }
}
