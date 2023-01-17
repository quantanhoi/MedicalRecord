package com.example.medrecord;

import java.util.ArrayList;

public class Singleton_Labor {
    private static Singleton_Labor labor;
    public ArrayList<Patient> getmPatients() {
        return mPatients;
    }

    private ArrayList<Patient> mPatients = new ArrayList<>();

    private Singleton_Labor(){
        mPatients = getPatientsSentToLab();
    };

    public static Singleton_Labor getLabor(){
        if(labor == null) {
            synchronized (Singleton_Labor.class) {
                if(labor == null) {
                    labor = new Singleton_Labor();
                    return labor;
                }
            }
        }
        labor.checkReleasedPatients();
        labor.checkAddedPatient();
        return labor;
    }

    private ArrayList<Patient> getPatientsSentToLab(){
        ArrayList<Patient> patients = new ArrayList<>();
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()){
            if(p.isToLab() && isPatientInList(p)) patients.add(p);
        }
        return patients;
    }
    public boolean isPatientInList(Patient p){
        for(Patient pat: Singleton_Patient_List.getInstance().getPatientsList()){
            if(p == pat) return true;
        }
        return false;
    }
    private void checkReleasedPatients(){
        for(Patient p: mPatients){
            if(!isPatientInList(p)) mPatients.remove(p);
        }
    }
    private void checkAddedPatient(){
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()){
            if(p.isToLab() && isPatientInList(p) && !isPatientInLabor(p)) mPatients.add(p);
        }
    }

    private boolean isPatientInLabor(Patient p){
        for(Patient pat: mPatients){
            if(p == pat) return true;
        }
        return false;
    }
}
