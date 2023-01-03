package com.example.medrecord;

import java.util.ArrayList;

public class Singleton_Patient_List {
    private static Singleton_Patient_List instance;
    private ArrayList<Patient> patientsList = new ArrayList<>();
    private Singleton_Patient_List() {
        patientsList.add(new Patient("Trung", "Thieu"));
        patientsList.add(new Patient("Jonas", "Herzberger"));
        patientsList.add(new Patient("Jane", "Doe"));
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
}
