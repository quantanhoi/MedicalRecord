package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Diagnose_Manage_Activity extends AppCompatActivity {

    Patient patient;
    Diagnose diagnose;
    TextView diagnoseDate;
    TextView Leukozyten_pro_nl;
    TextView Lymphozyten_in_Prozent_der_Leuko;
    TextView Lymphozyten_absolut_in_100_pro_nl;
    ImageView diagnoseImage;
    EditText docText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_manage);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String diagnoseDate = extras.getString("diagnoseDate");
            int patID = extras.getInt("patientID");
            patient = Singleton_Patient_List.getInstance().findPatientByID(patID);
            diagnose = patient.getDiagnoseByDate(diagnoseDate);
        }

        diagnoseDate = findViewById(R.id.created_date);
        Leukozyten_pro_nl = findViewById(R.id.created_Leukozyten_pro_nl);
        Lymphozyten_absolut_in_100_pro_nl = findViewById(R.id.created_Lymphozyten_absolut_in_100_pro_nl);
        Lymphozyten_in_Prozent_der_Leuko = findViewById(R.id.created_Lymphozyten_in_Prozent_der_Leuko);
        docText = findViewById(R.id.doctorInputBox);

        diagnoseDate.setText("Diagnose date: " + diagnose.getDate());
        Leukozyten_pro_nl.setText("Leukozyten pro nl: " + diagnose.Leukozyten_pro_nl);
        Lymphozyten_in_Prozent_der_Leuko.setText("Lymphozyten in Prozent der Leuko: " + diagnose.Lymphozyten_in_Prozent_der_Leuko);
        Lymphozyten_absolut_in_100_pro_nl.setText("Lymphozyten absolut in 100 pro nl: " + diagnose.Lymphozyten_absolut_in_100_pro_nl);


        if(!diagnose.doctorPrescription.isEmpty())
            docText.setText(diagnose.doctorPrescription);

    }
    public void onSaveDiagnoseClick(View view){
        String docNote = docText.getText().toString();
        diagnose.doctorPrescription = docNote;
        Toast.makeText(getApplicationContext(),"Doctor Comment Saved", Toast.LENGTH_SHORT).show();
    }
    public void onDeleteDiagnoseClick(View view){
        patient.deleteDiagnose(diagnose);
        Toast.makeText(getApplicationContext(),"Diagnose deleted", Toast.LENGTH_SHORT).show();
        finish();
    }
}