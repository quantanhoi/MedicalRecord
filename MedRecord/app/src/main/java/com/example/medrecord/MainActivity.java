package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "doctors.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonDoctorClick(View view) {
        openDoctorActivity();
    }
    public void openDoctorActivity() {
        Intent intent = new Intent(this, DoctorSelectionActivity.class);
        startActivity(intent);
    }
    public void onButtonAdminClick(View view) {
        openAdminActivity();
    }
    public void openAdminActivity() {
        Intent intent = new Intent(this, Admin_login_activity.class);
        startActivity(intent);
    }
    public void onButtonLaborClick(View view){
        Intent intent = new Intent(this, LaborActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onPause() {

        super.onPause();
        saveToJSONFile(this);
    }

    @Override
    protected void onStop() {

        super.onStop();
        saveToJSONFile(this);
    }

    public void saveToJSONFile(Context context){
        saveDoctors(context);
        savePatients(context);
    }
    public void saveDoctors(Context context){
        JSONArray savedDoctorList = new JSONArray();
        for (Doctor doc: Singleton_Doctor_List.getInstance().getDoctorsList()){
            JSONObject doctorDetails = new JSONObject();
            try{
                doctorDetails.put("docID", doc.getDocID());
                doctorDetails.put("docFirstName", doc.getFirstName());
                doctorDetails.put("docLastName", doc.getLastName());
                doctorDetails.put("docImage", doc.getImage());
                doctorDetails.put("staticDocID", Doctor.getDoctorID());

                JSONObject doctor = new JSONObject();
                doctor.put("doctor", doctorDetails);

                savedDoctorList.put(doctor.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream outputStream = context.openFileOutput("doctors.json", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedDoctorList.toString(4));
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_doctors_to_JSON", "Error saving doctor list to JSON file: " + e.getLocalizedMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePatients(Context context){
        JSONArray savedPatientList = new JSONArray();
        for (Patient pat: Singleton_Patient_List.getInstance().getPatientsList()){
            JSONObject patientDetails = new JSONObject();
            try{
                patientDetails.put("firstName", pat.getM_firstName());
                patientDetails.put("lastName", pat.getM_lastName());
                patientDetails.put("birthday", pat.getBirthday());
                patientDetails.put("gender", pat.getGender());
                patientDetails.put("age", pat.getAge());
                patientDetails.put("id", pat.getId());
                patientDetails.put("personalDoctorId", pat.getPersonalDoctorId());
                patientDetails.put("toLab", pat.isToLab());
                patientDetails.put("image", pat.getImage());

                JSONArray medicalHistory = new JSONArray();
                for (Diagnose diagnose : pat.getMedicalHistory()) {
                    JSONObject diagnoseDetails = new JSONObject();
                    diagnoseDetails.put("patientID", diagnose.patientID);
                    diagnoseDetails.put("diagnoseImage", diagnose.diagnoseImage);
                    diagnoseDetails.put("date", diagnose.date);
                    diagnoseDetails.put("Leukozyten_pro_nl", diagnose.Leukozyten_pro_nl);
                    diagnoseDetails.put("Lymphozyten_in_Prozent_der_Leuko", diagnose.Lymphozyten_in_Prozent_der_Leuko);
                    diagnoseDetails.put("Lymphozyten_absolut_in_100_pro_nl", diagnose.Lymphozyten_absolut_in_100_pro_nl);

                    medicalHistory.put(diagnoseDetails);
                }
                patientDetails.put("staticPatientID", Patient.getIdNummer());
                patientDetails.put("medicalHistory", medicalHistory);

                JSONObject patient = new JSONObject();
                patient.put("patient", patientDetails);

                savedPatientList.put(patient.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

            try {
            FileOutputStream outputStream = context.openFileOutput("patients.json", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedPatientList.toString(4));
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_patients_to_JSON", "Error saving patient list to JSON file: " + e.getLocalizedMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}