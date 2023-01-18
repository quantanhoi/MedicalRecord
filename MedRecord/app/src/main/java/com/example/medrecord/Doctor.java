package com.example.medrecord;

import java.util.ArrayList;
import java.util.Random;

public class Doctor {
    public static int getDoctorID() {
        return doctorID;
    }

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

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = R.drawable.d3;
        this.docID = doctorID++;
    }
    public Doctor(int ID, String firstName, String lastName, int image){
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.docID = ID;

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

    public void removePatientFromList(Patient p){
        patientList.remove(p);
    }


}
