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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }
}