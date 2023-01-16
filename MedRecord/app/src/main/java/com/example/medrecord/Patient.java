package com.example.medrecord;

public class Patient {
    public String getM_firstName() {
        return m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
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

    public int getId() {
        return id;
    }

    private int id;
    private String m_firstName;
    private String m_lastName;

    private int image;

    public int getPersonalDoctorId() {
        return personalDoctorId;
    }

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

    public Patient(String firstName, String lastName, int image) {
        this.m_firstName = firstName;
        this.m_lastName = lastName;
        this.image = image;
        this.toLab = false;
        this.personalDoctorId = 0;

        id = idNummer;
        idNummer++;
    }

}
