package com.example.medrecord;

import java.util.ArrayList;

public class Singleton_Doctor_List {
    private static Singleton_Doctor_List instance;
    private ArrayList<Doctor> doctorsList = new ArrayList<>();
    private Singleton_Doctor_List() {
        doctorsList.add(new Doctor("D1", "E1"));
        doctorsList.add(new Doctor("D2", "E2"));
        doctorsList.add(new Doctor("D3", "E3"));
    }
    public static Singleton_Doctor_List getInstance() {
        if(instance == null) {
            synchronized (Singleton_Doctor_List.class) {
                if(instance == null) {
                    instance = new Singleton_Doctor_List();
                }
            }
        }
        return instance;
    }
    public void addNewDoctor(Doctor doctor) {
        doctorsList.add(doctor);
    }
    public ArrayList<Doctor> getDoctorsList() {
        return doctorsList;
    }
}
