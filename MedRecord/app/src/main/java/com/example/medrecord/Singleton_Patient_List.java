package com.example.medrecord;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Singleton_Patient_List {
    private static Singleton_Patient_List instance;
    private ArrayList<Patient> patientsList = new ArrayList<>();
    private Singleton_Patient_List() {
        //if(patientsList.isEmpty()) addSamplePatients();
    }
    private void addSamplePatients(){
        patientsList.add(new Patient("Trung", "Thieu", "1999-11-16", "Male"));
        patientsList.add(new Patient("Jonas", "Herzberger","1975-04-30", "Divers"));
        patientsList.add(new Patient("Jane", "Doe", "1984-12-11", "Female"));

    }
    public static Singleton_Patient_List getInstance() {
        if(instance == null) {
            synchronized (Singleton_Patient_List.class) {
                if(instance == null) {
                    instance = new Singleton_Patient_List();
                }
            }
        }
        return instance;
    }
    public void addNewPatient(Patient patient) {
        patientsList.add(patient);
    }
    public ArrayList<Patient> getPatientsList() {
        return patientsList;
    }
    public Patient findPatientByID(int ID){
        for(Patient pat: patientsList){
            if(pat.getId() == ID) return pat;
        }
        return null;

    }
    public ArrayList<Patient> getAvailablePatients(){
        ArrayList<Patient> patients = new ArrayList<>();
        for(Patient p: patientsList){
            if(Singleton_Doctor_List.getInstance().getDoctorById(p.getPersonalDoctorId()) == null){
                patients.add(p);
            }
        }
        return patients;
    }
    public boolean isPatientAlreadyInList(Patient pat){
        for(Patient patient: patientsList){
            if(patient.getId() == pat.getId()) return true;
        }
        return false;
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
                    diagnoseDetails.put("doctorPrescription", diagnose.doctorPrescription);

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
            //Toast.makeText(context, "Saved to " + context.getFilesDir() + "/" + "patients.json",
                    //Toast.LENGTH_SHORT).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_patients_to_JSON", "Error saving patient list to JSON file: " + e.getLocalizedMessage());
        }
    }
}
