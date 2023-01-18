package com.example.medrecord;

import java.util.Date;

public class Diagnose {
    int diagnoseImage;

    int patientID;
    String date;
    double Leukozyten_pro_nl;
    double Lymphozyten_in_Prozent_der_Leuko;
    double Lymphozyten_absolut_in_100_pro_nl;

    public Diagnose(int patID, int diagnoseImage, String date, double leukozyten_pro_nl, double lymphozyten_in_Prozent_der_Leuko, double lymphozyten_absolut_in_100_pro_nl) {
        this.diagnoseImage = diagnoseImage;
        this.date = date;
        Leukozyten_pro_nl = leukozyten_pro_nl;
        Lymphozyten_in_Prozent_der_Leuko = lymphozyten_in_Prozent_der_Leuko;
        Lymphozyten_absolut_in_100_pro_nl = lymphozyten_absolut_in_100_pro_nl;
        patientID = patID;
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
