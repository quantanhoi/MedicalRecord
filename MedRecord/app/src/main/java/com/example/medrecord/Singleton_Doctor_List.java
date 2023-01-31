package com.example.medrecord;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Singleton class for doctor list
 */
public class Singleton_Doctor_List {
    private static Singleton_Doctor_List instance;
    private ArrayList<Doctor> doctorsList = new ArrayList<>();
    private Singleton_Doctor_List(){
        //if(doctorsList.isEmpty()) addTestingDoctors();
    }

    /**
     * test singleton class
     */
    private void addTestingDoctors(){
        doctorsList.add(new Doctor("Hans", "Landa", R.drawable.d1));
        doctorsList.add(new Doctor("Hans", "Fritz", R.drawable.d2));
        doctorsList.add(new Doctor("Johannes", "van Beck", R.drawable.d3));
        doctorsList.add(new Doctor("Dottie", "Wolmar", R.drawable.d3));
    }

    /**
     *
     * @return instance of the singleton class
     */
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

    /**
     * adding new doctor to singleton list
     * @param doctor new doctor added
     */
    public void addNewDoctor(Doctor doctor) {
        doctorsList.add(doctor);
    }

    /**
     *
     * @param index position of doctor to remove
     */
    public void removeDoctor(int index) {
        doctorsList.remove(index);
    }

    /**
     * @return getting all doctor in the list
     */
    public ArrayList<Doctor> getDoctorsList() {
        return doctorsList;
    }

    /**
     * search for doctor by using ID
     * @param ID of the doctor
     * @return doctor object
     */
    public Doctor getDoctorById(int ID){
        for (Doctor d : instance.doctorsList){
            if (d.getDocID() == ID) return d;
        }
        return null;
    }

    /**
     * check if doctor is already in the list
     * @param doc to find
     * @return true if doctor already in the list, otherwise false
     */
    public boolean isDoctorAlreadyInList(Doctor doc){
        for(Doctor doctor: doctorsList){
            if(doctor.getDocID() == doc.getDocID()) return true;
        }
        return false;
    }

    /**
     * save data of doctor to json file
     * @param context
     */
    public void saveDoctors(Context context){

        JSONArray savedDoctorList = new JSONArray();
        for (Doctor doc: Singleton_Doctor_List.getInstance().getDoctorsList()){
            JSONObject doctorDetails = new JSONObject();
            try{
                doctorDetails.put("docID", doc.getDocID());
                doctorDetails.put("docFirstName", doc.getFirstName());
                doctorDetails.put("docLastName", doc.getLastName());
                doctorDetails.put("docImage", doc.getImage());
                doctorDetails.put("staticDocID", Doctor.getDoctorID());

                JSONObject doctor = new JSONObject();
                doctor.put("doctor", doctorDetails);

                savedDoctorList.put(doctor);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream outputStream = context.openFileOutput("doctors.json", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedDoctorList.toString());
            //Toast.makeText(context.getApplicationContext(), "Saved to " + context.getFilesDir() + "/" + "doctors.json",
                    //Toast.LENGTH_SHORT).show();
            writer.close();
        } catch (IOException e) {
            Log.e("saving_doctors_to_JSON", "Error saving doctor list to JSON file: " + e.getLocalizedMessage());
        }
//        catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
    }
}
