package com.example.medrecord;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPatientActivity extends AppCompatActivity {
    /**
     * init activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String gender[] = {"Male", "Female", "Divers"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, gender);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

    /**
     * resume the activity
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * adding patient to singleton patient list with the written information
     * @param view
     */
    public void addPatientClick(View view) {
        EditText edText = findViewById(R.id.editPersonFirstName);
        String firstName = edText.getText().toString();
        edText = findViewById(R.id.editTextPersonLastName);
        String lastName = edText.getText().toString();
        Spinner spinner = findViewById(R.id.spinner);
        if(edText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all the information", Toast.LENGTH_SHORT).show();
            return;
        }
        //must use .isEmpty, == "" won't work
        //return when no string get input
        //TODO: make a pop up notification saying that input error

        edText = findViewById(R.id.editBirthday);
        String patientBirthday = edText.getText().toString();
        String patientGender = spinner.getSelectedItem().toString();
        if(firstName.isEmpty() || lastName.isEmpty()|| patientBirthday.isEmpty() || patientGender.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all the information", Toast.LENGTH_SHORT).show();
            return;
        }
        //TODO: also make a pop up notification for this

        Singleton_Patient_List.getInstance().addNewPatient(new Patient(firstName, lastName, patientBirthday, patientGender));
        finish();
    }

    /**
     * open manage patient activity
     */
    public void openManagePatientActivity() {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }

    /**
     * Handler for navigation back button
     * @return true if button is pressed
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Save and write the current data to json file
     */
    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }
}