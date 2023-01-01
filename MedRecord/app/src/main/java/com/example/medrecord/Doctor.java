package com.example.medrecord;

import java.util.ArrayList;
import java.util.Random;

public class Doctor {
    private static int doctorID = 1110000;

    private String firstName;
    private String lastName;
    private int docID;
    private int image;

    public int getImage() {
        return image;
    }

    public int getDocID() {
        return docID;
    }
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
        this.docID = doctorID++;
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
