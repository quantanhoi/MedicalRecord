package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class AddPatientActivity extends AppCompatActivity {
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
        Singleton_Patient_List.getInstance().addNewPatient(new Patient(firstName, lastName));
        finish();

    }
}