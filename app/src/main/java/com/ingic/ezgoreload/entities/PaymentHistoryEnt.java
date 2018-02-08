package com.ingic.ezgoreload.entities;

/**
 * Created on 9/8/2017.
 */

public class PaymentHistoryEnt {
    private String Date;
    private String Time;
    private String Location;
    private String ChargedCredit;
    private String CreditLeft;

    public PaymentHistoryEnt(String date, String time, String location, String chargedCredit, String creditLeft) {
        Date = date;
        Time = time;
        Location = location;
        ChargedCredit = chargedCredit;
        CreditLeft = creditLeft;
    }

    public String getCreditLeft() {
        return CreditLeft;
    }

    public void setCreditLeft(String creditLeft) {
        CreditLeft = creditLeft;
    }

    public String getChargedCredit() {
        return ChargedCredit;
    }

    public void setChargedCredit(String chargedCredit) {
        ChargedCredit = chargedCredit;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
