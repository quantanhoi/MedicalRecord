package com.example.medrecord;

import java.util.ArrayList;

public class Doctor {
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    ArrayList<Patient> patientList = new ArrayList<>();
    public Doctor() {
    }
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
}
