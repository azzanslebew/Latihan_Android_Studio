package com.example.aplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.widget.CompoundButton;
import android.text.method.PasswordTransformationMethod;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin;
    CheckBox checkPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtUsername = findViewById(R.id.Username);
        txtPassword = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action button

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if (username.equals("Azzan") && password.equals("Azzan123")) {
                    Toast.makeText(MainActivity.this, "Login Succesfuly!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AritmatikKalkulator.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtPassword = findViewById(R.id.Password);
        checkPassword = findViewById(R.id.checkShowPassword);
        txtPassword.setTransformationMethod(new PasswordTransformationMethod());
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    txtPassword.setTransformationMethod(null);
                } else {
                    txtPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });
    }
}
