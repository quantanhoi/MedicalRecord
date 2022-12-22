package com.example.medrecord;

import java.util.ArrayList;

public class Doctor {

    private String firstName;
    private String lastName;
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    private ArrayList<Patient> patientList = new ArrayList<>();
    public Doctor() {
    }
    public Doctor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return lastName + ", " + firstName;
    }
}
