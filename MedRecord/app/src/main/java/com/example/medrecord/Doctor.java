package com.example.medrecord;

import java.util.ArrayList;

public class Doctor {
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    ArrayList<Patient> patientList = new ArrayList<>();
    public Doctor() {
        addPatient(new Patient("Trung", "Thieu"));
        addPatient(new Patient("Quang", "Tran"));
        addPatient(new Patient("Boris", "Augustin"));
        addPatient(new Patient("Jordis", "Ortun"));
        addPatient(new Patient("Engel", "Annika"));
        addPatient(new Patient("Sofie", "Berthold"));
        addPatient(new Patient("Jakob", "Jochim"));
        addPatient(new Patient("Franzi", "Carolin"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
        addPatient(new Patient("Helma", "Jakob"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));
//        patientList.add(new Patient("Trung", "Thieu"));


    }
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
}
