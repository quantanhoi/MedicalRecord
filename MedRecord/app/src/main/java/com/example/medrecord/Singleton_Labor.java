package com.example.medrecord;

import java.util.ArrayList;

/**
 * Singleton class for labor
 */
public class Singleton_Labor {

    private static Singleton_Labor labor;

    /**
     * patient list added to labor
     * @return patient list added to labor
     */
    public ArrayList<Patient> getmPatients() {
        return mPatients;
    }

    /**
     * patient list added to labor
     */
    private ArrayList<Patient> mPatients = new ArrayList<>();

    /**
     * get instance of singleton class
     */
    private Singleton_Labor(){
        mPatients = getPatientsSentToLab();
    };

    /**
     * @return the labor of this instance
     */
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

    /**
     *
     * @return list of patient that sent to lab
     */
    private ArrayList<Patient> getPatientsSentToLab(){
        ArrayList<Patient> patients = new ArrayList<>();
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()){
            if(p.isToLab() && isPatientInList(p)) patients.add(p);
        }
        return patients;
    }

    /**
     *
     * @param p patient to find
     * @return true if p already in the list
     */
    public boolean isPatientInList(Patient p){
        for(Patient pat: Singleton_Patient_List.getInstance().getPatientsList()){
            if(p == pat) return true;
        }
        return false;
    }

    /**
     * release patient
     */
    private void checkReleasedPatients(){
        for(Patient p: mPatients){
            if(!isPatientInList(p)) mPatients.remove(p);
        }
    }

    /**
     * adding all sent patient to the list
     */
    private void checkAddedPatient(){
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()){
            if(p.isToLab() && isPatientInList(p) && !isPatientInLabor(p)) mPatients.add(p);
        }
    }

    /**

     * @param p patient to find
     * @return true if p already in labor
     */
    private boolean isPatientInLabor(Patient p){
        for(Patient pat: mPatients){
            if(p == pat) return true;
        }
        return false;
    }
}
