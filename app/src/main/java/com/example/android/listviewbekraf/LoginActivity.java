package com.example.android.listviewbekraf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.listviewbekraf.Utilities.PrefManager;

/**
 * Created by DITHA on 28/06/2017.
 */

public class LoginActivity extends AppCompatActivity {

    EditText ET_USERNAME, ET_PASSWORD;
    Button BTN_LOGIN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ET_USERNAME = (EditText) findViewById(R.id.etUsername);
        ET_PASSWORD = (EditText) findViewById(R.id.etPassword);
        BTN_LOGIN = (Button) findViewById(R.id.btnLogin);

        BTN_LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

            }
        });
    }

    private void validate() {
        String inputedUsername = ET_USERNAME.getText().toString();
        String inputedPassword = ET_PASSWORD.getText().toString();

        String uname = "Andre";
        String pass = "123";


        if ((inputedUsername.equals(uname)) && (inputedPassword.equals(pass))){

            new PrefManager().saveBoolean(this, "isLoggedIn", true);
            new PrefManager().saveString(this, "username", uname);

            Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
            Intent utama = new Intent(getApplicationContext(), MainRecyclerView.class);
            startActivity(utama);
            this.finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Username atau Password Salah", Toast.LENGTH_LONG).show();
        }
    }
}
