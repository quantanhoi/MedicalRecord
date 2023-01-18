package com.example.medrecord;

import java.util.ArrayList;

public class Patient {
    public String getM_firstName() {
        return m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }
    public String getBirthday() {return birthday;}
    public String getGender() {return gender;}
    public static int getIdNummer() {
        return idNummer;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Diagnose> getMedicalHistory() {
        return medicalHistory;
    }
    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getName(){
        return m_lastName + ", " + m_firstName;
    }
    private static int idNummer = 100000;
    private int id;
    private String m_firstName;
    private String m_lastName;

    private int image;



    private int age;
    private String gender;
    private String birthday;

    private ArrayList<Diagnose>medicalHistory ;


    public int getId() {
        return id;
    }


    //private Appointment appointment;

    public void addDiagnose(Diagnose d){
        medicalHistory.add(d);
    }

    public int getPersonalDoctorId() {
        return personalDoctorId;
    }

//    public void createAppointment(int day, int month, int year, String title, String note) {
//        this.appointment = new Appointment(day, month, year, title, note);
//    }

    public void setPersonalDoctorId(int personalDoctorId) {
        this.personalDoctorId = personalDoctorId;
    }

    private int personalDoctorId;

    public boolean isToLab() {
        return toLab;
    }

    public void setToLab(boolean toLab) {
        this.toLab = toLab;
    }

    private boolean toLab;

    public int getImage() {
        return image;
    }

    public Patient(String firstName, String lastName ,String birthday, String gender ) {
        this.m_firstName = firstName;
        this.m_lastName = lastName;
        this.image = R.drawable.default_p;

        //this.image = image;
        this.toLab = false;

        this.personalDoctorId = 0;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.medicalHistory = new ArrayList<>();

        id = idNummer;
        idNummer++;
    }

}
