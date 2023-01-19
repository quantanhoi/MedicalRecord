package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManageDoctorInvidivdualEditActivity extends AppCompatActivity {
    public static int doctorID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor_invidivdual_edit);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            doctorID = extras.getInt("doctorID");
        }



    }
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
}