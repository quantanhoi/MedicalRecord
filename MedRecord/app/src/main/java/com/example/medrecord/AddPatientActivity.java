package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPatientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public void addPatientClick(View view) {
        EditText edText = findViewById(R.id.editPersonFirstName);
        String firstName = edText.getText().toString();
        edText = findViewById(R.id.editTextPersonLastName);
        String lastName = edText.getText().toString();
        int image = R.drawable.p1;
        Singleton_Patient_List.getInstance().addNewPatient(new Patient(firstName, lastName, image));
        finish();
    }
    public void openManagePatientActivity() {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }
}