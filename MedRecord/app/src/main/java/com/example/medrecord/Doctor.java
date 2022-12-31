package com.example.medrecord;

import java.util.ArrayList;

public class Doctor {

    private String firstName;
    private String lastName;

    public int getImage() {
        return image;
    }

    private int image;
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    private ArrayList<Patient> patientList = new ArrayList<>();
    public Doctor() {
    }
    public Doctor(String firstName, String lastName, int image){
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
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
