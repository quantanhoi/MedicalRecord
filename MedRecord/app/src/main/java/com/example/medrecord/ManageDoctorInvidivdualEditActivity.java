package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManageDoctorInvidivdualEditActivity extends AppCompatActivity {
    public static int doctorID;
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor_invidivdual_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            doctorID = extras.getInt("doctorID");
        }



    }

    /**
     * handler for confirm button
     * @param view
     */
    public void ConfirmClick(View view) {
        EditText editText = findViewById(R.id.editPersonFirstName);
        String docFirstname = editText.getText().toString();
        editText = findViewById(R.id.editPersonLastName);
        String docLastname = editText.getText().toString();
        Singleton_Doctor_List.getInstance().getDoctorById(doctorID).setFirstName(docFirstname);
        Singleton_Doctor_List.getInstance().getDoctorById(doctorID).setLastName(docLastname);
        Toast.makeText(view.getContext(), "Information Changed", Toast.LENGTH_SHORT).show();
        finish();
    }
    /**
     * Handler for navigation button
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