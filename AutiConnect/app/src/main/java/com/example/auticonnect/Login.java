package com.example.auticonnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText phone_in, pass_in;
    Button btnSignIn;
    TextView signUpRedict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass_in = findViewById(R.id.password_signin);
        phone_in = findViewById(R.id.phone_signin);
        btnSignIn = findViewById(R.id.btnSignIn);
        signUpRedict = findViewById(R.id.signUpRedict);

        btnSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (pass_in.getText().toString().equals("123") && phone_in.getText().toString().equals("an")) {
                    Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Question_activity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(Login.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}