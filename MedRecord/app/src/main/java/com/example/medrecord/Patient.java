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
    private static int idNummer = 100000;

    public int getId() {
        return id;
    }

    private int id;
    String m_firstName;
    String m_lastName;

    public Patient(String firstName, String lastName) {
        this.m_firstName = firstName;
        this.m_lastName = lastName;

        id = idNummer;
        idNummer++;
    }

}
