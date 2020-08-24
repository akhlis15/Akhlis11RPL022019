package com.example.akhlis11rpl022019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText txtusername , txtpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                pref = getSharedPreferences("login" ,MODE_PRIVATE);
        txtusername = findViewById(R.id.txt_username);
        txtpassword = findViewById(R.id.txt_password);
        btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtusername.getText().toString().equalsIgnoreCase("admin")&&
                        txtpassword.getText().toString().equalsIgnoreCase("admin")){
                    editor = pref.edit();
                    editor.putString("username", txtusername.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), Mainmenu.class));
                    finish();
                }
            }
        });
    }
}
