package com.example.medrecord;

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
}
