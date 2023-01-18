package com.example.medrecord;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Singleton_Doctor_List {
    private static Singleton_Doctor_List instance;
    private ArrayList<Doctor> doctorsList = new ArrayList<>();
    private Singleton_Doctor_List(){
        //if(doctorsList.isEmpty()) addTestingDoctors();
    }

    private void addTestingDoctors(){
        doctorsList.add(new Doctor("Hans", "Landa", R.drawable.d1));
        doctorsList.add(new Doctor("Hans", "Fritz", R.drawable.d2));
        doctorsList.add(new Doctor("Johannes", "van Beck", R.drawable.d3));
        doctorsList.add(new Doctor("Dottie", "Wolmar", R.drawable.d3));
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

    public Doctor getDoctorById(int ID){
        for (Doctor d : instance.doctorsList){
            if (d.getDocID() == ID) return d;
        }
        return null;
    }

    public boolean isDoctorAlreadyInList(Doctor doc){
        for(Doctor doctor: doctorsList){
            if(doctor.getDocID() == doc.getDocID()) return true;
        }
        return false;
    }
}
