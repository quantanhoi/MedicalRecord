package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPatientActivity extends AppCompatActivity {
    public static Patient newPatient = new Patient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
    }

    public void addPatientClick(View view) {

        EditText edText = findViewById(R.id.editPersonFirstName);

        String firstName = edText.getText().toString();
        edText = findViewById(R.id.editTextPersonLastName);
        String lastName = edText.getText().toString();
        newPatient.setM_firstName(firstName);
        newPatient.setM_lastName(lastName);
        finish();
    }
}