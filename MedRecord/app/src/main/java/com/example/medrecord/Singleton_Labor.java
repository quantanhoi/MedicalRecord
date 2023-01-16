package com.example.medrecord;

import java.util.ArrayList;

public class Singleton_Labor {
    private static Singleton_Labor labor;
    public ArrayList<Patient> getmPatients() {
        return mPatients;
    }

    private ArrayList<Patient> mPatients = new ArrayList<>();

    private Singleton_Labor(){};

    public static Singleton_Labor getLabor(){
        if(labor == null) {
            synchronized (Singleton_Labor.class) {
                if(labor == null) {
                    labor = new Singleton_Labor();
                }
            }
        }
        return labor;
    }

    public void addPatient(Patient p){
        mPatients.add(p);
    }
}
