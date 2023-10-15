package com.example.auticonnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Personal extends AppCompatActivity {

    Button submit2;
    CardView card2, card3, card4, car5, card6, card7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        submit2 = findViewById(R.id.submit2);

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Personal.this, Character.class);
                startActivity(intent);
            }
        });


    }
}