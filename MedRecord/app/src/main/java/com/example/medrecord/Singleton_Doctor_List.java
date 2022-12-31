package com.example.medrecord;

import java.util.ArrayList;

public class Singleton_Doctor_List {
    private static Singleton_Doctor_List instance;
    private ArrayList<Doctor> doctorsList = new ArrayList<>();
    private Singleton_Doctor_List() {
        doctorsList.add(new Doctor("Hans", "Landa", R.drawable.doctor_symbol));
        doctorsList.add(new Doctor("Hans", "Fritz", R.drawable.doctor_symbol));
        doctorsList.add(new Doctor("Johannes", "van Beck", R.drawable.doctor_symbol));
        doctorsList.add(new Doctor("Dottie", "Wolmar", R.drawable.doctor_symbol));
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
