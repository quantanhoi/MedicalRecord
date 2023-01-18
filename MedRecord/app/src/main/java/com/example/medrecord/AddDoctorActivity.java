package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);
    }
    public void addDoctorClick(View view){
        EditText eText = findViewById(R.id.editPersonFirstName);
        String dFirstName = eText.getText().toString();
        eText = findViewById(R.id.editTextPersonLastName);
        String dLastName = eText.getText().toString();
        Doctor newDoctor = new Doctor(dFirstName, dLastName);
        if(dFirstName.equals("") || dLastName.equals("")) {
            return;
        }
        else {
            Singleton_Doctor_List.getInstance().addNewDoctor(newDoctor);
            finish();
        }
    }
}