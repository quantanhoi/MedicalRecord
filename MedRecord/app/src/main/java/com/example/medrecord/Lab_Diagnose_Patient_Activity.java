package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

/**
 * lab diagnose activity
 */
public class Lab_Diagnose_Patient_Activity extends AppCompatActivity {
    /**
     * patient to diagnose
     */
    Patient patient;
    /**
     * date of diagnosis
     */
    String date;
    /**
     * data for diagnosis
     */
    double Leukozyten_pro_nl;
    double Lymphozyten_in_Prozent_der_Leuko;
    double Lymphozyten_absolut_in_100_pro_nl;
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_diagnose_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String patientName = extras.getString("patientName");
            ArrayList<Patient> patientList = Singleton_Labor.getLabor().getmPatients();

            for (Patient p: patientList){
                if(Objects.equals(p.getName(), patientName)){
                    patient = p;
                    break;
                }
            }
        }

    }

    /**
     * saving data to diagnosis
     * @param view
     */
    public void saveDiagnose(View view){
        EditText tmpDate = (EditText) findViewById(R.id.date);
        date = tmpDate.getText().toString();

        EditText tmpProNL = (EditText) findViewById(R.id.Leukozyten_pro_nl);
        Leukozyten_pro_nl = Double.parseDouble(tmpProNL.getText().toString());

        EditText tmpPro = (EditText) findViewById(R.id.Lymphozyten_in_Prozent_der_Leuko);
        Lymphozyten_in_Prozent_der_Leuko = Double.parseDouble(tmpPro.getText().toString());

        EditText tmpAbs = (EditText) findViewById(R.id.Lymphozyten_absolut_in_100_pro_nl);
        Lymphozyten_absolut_in_100_pro_nl = Double.parseDouble(tmpAbs.getText().toString());

        int image = R.drawable.dignose01;
        patient.addDiagnose(new Diagnose(patient.getId(), image, date, Leukozyten_pro_nl,
                Lymphozyten_in_Prozent_der_Leuko, Lymphozyten_absolut_in_100_pro_nl));

        Toast.makeText(this.getApplicationContext(),
                "Diagnose added. Patient will be sent back to doctor", Toast.LENGTH_SHORT).show();

        Singleton_Labor theLab = Singleton_Labor.getLabor();
        patient.setToLab(false);
        theLab.getmPatients().remove(patient);
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