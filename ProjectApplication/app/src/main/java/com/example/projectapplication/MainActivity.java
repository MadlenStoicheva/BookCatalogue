package com.example.projectapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3;
    Button btnRegister;
    Button btnLogin;
    TextView txtViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.editEmail);
        e2 = (EditText) findViewById(R.id.editPassword);
        e3 = (EditText) findViewById(R.id.editConfirmPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtViewLogin = (TextView) findViewById(R.id.textViewLogin);

        txtViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("")|| s2.equals("") || s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)==true){
                        Boolean checkemail = db.checkemail(s1);
                        if (checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Username already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password do not match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
