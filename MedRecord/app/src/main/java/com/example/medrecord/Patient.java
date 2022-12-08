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

    String m_firstName;
    String m_lastName;

    public Patient() {
        this.m_firstName = "default First Name";
        this.m_lastName = "default Last Name";
    }

}
