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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "doctors.json";
    private static final String FILE_NAME_2 = "patients.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readJSONFiles(this);
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
        Intent intent = new Intent(this, AdminLoginActivity.class);
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
    protected void onResume() {
        super.onResume();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        saveToJSONFile(this);
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveToJSONFile(this);
    }




    public void saveToJSONFile(Context context){
        saveDoctors(context);
        savePatients(context);
    }
    public void readJSONFiles(Context context){
        readJSON_Doctors();
        readJSON_Patients();
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

                savedDoctorList.put(doctor);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream outputStream = context.openFileOutput("doctors.json", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedDoctorList.toString());
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_SHORT).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_doctors_to_JSON", "Error saving doctor list to JSON file: " + e.getLocalizedMessage());
        }
//        catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
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

                savedPatientList.put(patient);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

            try {
            FileOutputStream outputStream = context.openFileOutput("patients.json", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedPatientList.toString());
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME_2,
                    Toast.LENGTH_SHORT).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_patients_to_JSON", "Error saving patient list to JSON file: " + e.getLocalizedMessage());
        }
    }

    public void readJSON_Doctors(){
        try {
            FileInputStream inputStream = openFileInput("doctors.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[4096];
            int read;
            while ((read = reader.read(buffer)) > 0) {
                builder.append(buffer, 0, read);
            }
            reader.close();
            JSONArray doctorList = new JSONArray(builder.toString());
            for (int i = 0; i < doctorList.length(); i++) {
                if(Singleton_Doctor_List.getInstance().getDoctorsList().size() == doctorList.length()) break;
                JSONObject doctor = doctorList.getJSONObject(i);
                JSONObject doctorDetails = doctor.getJSONObject("doctor");
                int docID = (doctorDetails.getInt("docID"));
                String firstName = doctorDetails.getString("docFirstName");
                String lastName = doctorDetails.getString("docLastName");
                int image = doctorDetails.getInt("docImage");
                Doctor.setDoctorID((doctorDetails.getInt("staticDocID")));

                Singleton_Doctor_List.getInstance().addNewDoctor(new Doctor(docID, firstName, lastName, image));
            }
        } catch (IOException | JSONException e){
            e.printStackTrace();
        }
    }

    public void readJSON_Patients() {
        try {
            FileInputStream inputStream = openFileInput("patients.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[4096];
            int read;
            while ((read = reader.read(buffer)) > 0) {
                builder.append(buffer, 0, read);
            }
            reader.close();
            JSONArray patientList = new JSONArray(builder.toString());
            for (int i = 0; i < patientList.length(); i++) {
                if(Singleton_Patient_List.getInstance().getPatientsList().size() == patientList.length()) break;
                JSONObject patient = patientList.getJSONObject(i);
                JSONObject patientDetails = patient.getJSONObject("patient");

                String firstName = patientDetails.getString("firstName");
                String lastName = patientDetails.getString("lastName");
                String birthday = patientDetails.getString("birthday");
                String gender = patientDetails.getString("gender");
                int age = patientDetails.getInt("age");
                int id = patientDetails.getInt("id");
                int personalDoctorId = patientDetails.getInt("personalDoctorId");
                boolean toLab = patientDetails.getBoolean("toLab");
                int image = patientDetails.getInt("image");
                int staticPatientID = patientDetails.getInt("staticPatientID");
                JSONArray medicalHistory = patientDetails.getJSONArray("medicalHistory");
                ArrayList<Diagnose> diagnoseList = new ArrayList<>();
                for (int j = 0; j < medicalHistory.length(); j++) {
                    JSONObject diagnoseDetails = medicalHistory.getJSONObject(j);
                    int patientID = diagnoseDetails.getInt("patientID");
                    int diagnoseImage = diagnoseDetails.getInt("diagnoseImage");
                    String date = diagnoseDetails.getString("date");
                    int Leukozyten_pro_nl = diagnoseDetails.getInt("Leukozyten_pro_nl");
                    int Lymphozyten_in_Prozent_der_Leuko = diagnoseDetails.getInt("Lymphozyten_in_Prozent_der_Leuko");
                    int Lymphozyten_absolut_in_100_pro_nl = diagnoseDetails.getInt("Lymphozyten_absolut_in_100_pro_nl");
                    diagnoseList.add(new Diagnose(patientID, diagnoseImage, date, Leukozyten_pro_nl, Lymphozyten_in_Prozent_der_Leuko, Lymphozyten_absolut_in_100_pro_nl));
                }

                Patient pat = new Patient(id, firstName, lastName, image,age, gender, birthday, diagnoseList, personalDoctorId, toLab);
                Singleton_Patient_List.getInstance().addNewPatient(pat);
                Patient.setIdNummer(staticPatientID);
                Doctor doc = Singleton_Doctor_List.getInstance().getDoctorById(personalDoctorId);
                if(doc!=null) doc.addPatient(pat);
            }

        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}