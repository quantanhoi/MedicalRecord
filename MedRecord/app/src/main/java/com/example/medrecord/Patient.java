package com.example.medrecord;

public class Patient {
    public String getM_firstName() {
        return m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }
    public String getBirthday() {return birthday;}
    public String getGender() {return gender;}
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
    private int age;
    private String gender;
    private String birthday;

    public int getPersonalDoctorId() {
        return personalDoctorId;
    }

    public void setPersonalDoctorId(int personalDoctorId) {
        this.personalDoctorId = personalDoctorId;
    }

    private int personalDoctorId;

    public int getImage() {
        return image;
    }

    public Patient(String firstName, String lastName ,String birthday, String gender ) {
        this.m_firstName = firstName;
        this.m_lastName = lastName;
        this.image = R.drawable.default_p;
        this.personalDoctorId = 0;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;

        id = idNummer;
        idNummer++;
    }

}
