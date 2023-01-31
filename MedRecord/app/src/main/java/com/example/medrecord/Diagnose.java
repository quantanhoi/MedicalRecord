package com.example.medrecord;

import java.util.Date;

/**
 * Diagnosis from the lab
 */
public class Diagnose {
    /**
     * Image for diagnosis
     */
    int diagnoseImage;
    /**
     * id of patient to be diagnosed
     */
    int patientID;

    /**
     * @return date of diagnosis
     */
    public String getDate() {
        return date;
    }

    /**
     * date of diagnosis
     */
    String date;
    /**
     * data for blood test and diagnosis
     */
    double Leukozyten_pro_nl;
    double Lymphozyten_in_Prozent_der_Leuko;
    double Lymphozyten_absolut_in_100_pro_nl;

    /**
     * Prescription from responsible doctor
     */
    String doctorPrescription;

    /**
     * setting up diagnosis
     * @param patID patient's id
     * @param diagnoseImage diagnosis's image
     * @param date date of diagnosis
     * @param leukozyten_pro_nl data for blood test
     * @param lymphozyten_in_Prozent_der_Leuko
     * @param lymphozyten_absolut_in_100_pro_nl
     */
    public Diagnose(int patID, int diagnoseImage, String date, double leukozyten_pro_nl, double lymphozyten_in_Prozent_der_Leuko, double lymphozyten_absolut_in_100_pro_nl) {
        this.diagnoseImage = diagnoseImage;
        this.date = date;
        Leukozyten_pro_nl = leukozyten_pro_nl;
        Lymphozyten_in_Prozent_der_Leuko = lymphozyten_in_Prozent_der_Leuko;
        Lymphozyten_absolut_in_100_pro_nl = lymphozyten_absolut_in_100_pro_nl;
        patientID = patID;
        doctorPrescription = "";
    }

    public Diagnose(int patID, int diagnoseImage, String date, double leukozyten_pro_nl, double lymphozyten_in_Prozent_der_Leuko, double lymphozyten_absolut_in_100_pro_nl, String docNote) {
        this.diagnoseImage = diagnoseImage;
        this.date = date;
        Leukozyten_pro_nl = leukozyten_pro_nl;
        Lymphozyten_in_Prozent_der_Leuko = lymphozyten_in_Prozent_der_Leuko;
        Lymphozyten_absolut_in_100_pro_nl = lymphozyten_absolut_in_100_pro_nl;
        patientID = patID;
        doctorPrescription = docNote;
    }

    public Diagnose(int patID, String date, double leukozyten_pro_nl, double lymphozyten_in_Prozent_der_Leuko, double lymphozyten_absolut_in_100_pro_nl) {
        this.date = date;
        Leukozyten_pro_nl = leukozyten_pro_nl;
        Lymphozyten_in_Prozent_der_Leuko = lymphozyten_in_Prozent_der_Leuko;
        Lymphozyten_absolut_in_100_pro_nl = lymphozyten_absolut_in_100_pro_nl;
        diagnoseImage = 0;
        patientID = patID;
    }
}
