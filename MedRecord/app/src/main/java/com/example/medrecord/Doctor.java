package com.example.medrecord;

import java.util.ArrayList;

public class Doctor {
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    ArrayList<Patient> patientList = new ArrayList<>();
    public Doctor() {
        addPatient("Trung", "Thieu");
        addPatient("Quang", "Tran");
        addPatient("Boris", "Augustin");
        addPatient("Jordis", "Ortun");
        addPatient("Engel", "Annika");
        addPatient("Sofie", "Berthold");
        addPatient("Jakob", "Jochim");
        addPatient("Franzi", "Carolin");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");
        addPatient("Helma", "Jakob");


    }
    public void addPatient(String firstName, String lastName) {
        Patient p = new Patient();
        p.setM_lastName(firstName);
        p.setM_lastName(lastName);
        patientList.add(p);
    }
}
