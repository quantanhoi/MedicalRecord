package com.example.medrecord;


/**
 * supposed to used for appointment booking, is not yet used
 */
public class Appointment {
    private int day, month, year;
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}
    private String title;
    private String note;
    public String getTitle() {return title;}
    public String getNote() {return note;}
    public Appointment(int day, int month, int year, String title, String note)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.title = title;
        this.note = note;
    }


}
