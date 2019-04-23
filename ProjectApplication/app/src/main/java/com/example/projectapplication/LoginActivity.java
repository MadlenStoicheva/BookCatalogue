package com.example.projectapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn;
    DatabaseHelper db;
    TextView txtViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.editEmail);
        e2 = (EditText) findViewById(R.id.editPassword);
        btn = (Button) findViewById(R.id.btnLogin);
        txtViewRegister = (TextView) findViewById(R.id.textViewRegister);

        txtViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String pass = e2.getText().toString();
                boolean checkEmailAndPass = db.checkemailpassword(email,pass);

                if (checkEmailAndPass==true){
                   // Toast.makeText(getApplicationContext(), "Successfully Login!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    i.putExtra("email",email);
                    startActivity(i);


                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
