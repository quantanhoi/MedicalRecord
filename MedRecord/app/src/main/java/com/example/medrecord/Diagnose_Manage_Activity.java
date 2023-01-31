package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Diagnose_Manage_Activity extends AppCompatActivity {
    /**
     * Patient to diagnose
     */
    Patient patient;
    /**
     * Diagnosis from the lab
     */
    Diagnose diagnose;
    TextView diagnoseDate;
    TextView Leukozyten_pro_nl;
    TextView Lymphozyten_in_Prozent_der_Leuko;
    TextView Lymphozyten_absolut_in_100_pro_nl;
    ImageView diagnoseImage;
    EditText docText;
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_manage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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

        SpannableString diagnoseDateString = new SpannableString("Diagnose date: " + diagnose.getDate());
        diagnoseDateString.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, 0);
        diagnoseDate.setText(diagnoseDateString);

        SpannableString Leukozyten_pro_nlString = new SpannableString("Leukozyten pro nl: " + diagnose.Leukozyten_pro_nl);
        Leukozyten_pro_nlString.setSpan(new StyleSpan(Typeface.BOLD), 0, 16, 0);
        Leukozyten_pro_nl.setText(Leukozyten_pro_nlString);

        SpannableString Lymphozyten_in_Prozent_der_LeukoString = new SpannableString("Lymphozyten in Prozent der Leuko: " + diagnose.Lymphozyten_in_Prozent_der_Leuko);
        Lymphozyten_in_Prozent_der_LeukoString.setSpan(new StyleSpan(Typeface.BOLD), 0, 32, 0);
        Lymphozyten_in_Prozent_der_Leuko.setText(Lymphozyten_in_Prozent_der_LeukoString);

        SpannableString Lymphozyten_absolut_in_100_pro_nlString = new SpannableString("Lymphozyten absolut in 100 pro nl: " + diagnose.Lymphozyten_absolut_in_100_pro_nl);
        Lymphozyten_absolut_in_100_pro_nlString.setSpan(new StyleSpan(Typeface.BOLD), 0, 34, 0);
        Lymphozyten_absolut_in_100_pro_nl.setText(Lymphozyten_absolut_in_100_pro_nlString);



        if(!diagnose.doctorPrescription.isEmpty())
            docText.setText(diagnose.doctorPrescription);

    }

    /**
     * Handler for Save Diagnose button
     * @param view
     */
    public void onSaveDiagnoseClick(View view){
        String docNote = docText.getText().toString();
        diagnose.doctorPrescription = docNote;
        Toast.makeText(getApplicationContext(),"Doctor Comment Saved", Toast.LENGTH_SHORT).show();
    }

    /**
     * Handler for Delete Diagnose button
     * @param view
     */
    public void onDeleteDiagnoseClick(View view){
        patient.deleteDiagnose(diagnose);
        Toast.makeText(getApplicationContext(),"Diagnose deleted", Toast.LENGTH_SHORT).show();
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