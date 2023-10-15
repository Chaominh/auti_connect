package com.example.auticonnect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Question_activity extends AppCompatActivity {

    TextView txtView1, mDate;
    DatePickerDialog.OnDateSetListener mDateListener;
    Spinner spinnerText;
    Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        mDate = (TextView) findViewById(R.id.tvdate);
        mDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Question_activity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+= 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                mDate.setText(date);
            }
        };

        spinnerText = findViewById(R.id.gender);
        String[] textSize = getResources().getStringArray(R.array.gender);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, textSize);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerText.setAdapter((adapter));
        submit1 = findViewById(R.id.submit1);
        submit1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_activity.this, Personal.class);
                startActivity(intent);
            }
        });
    }

}