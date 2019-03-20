package com.example.john.munchies;

public class CreditCardClass {


    private String holderName;
    private String creditCardNumber;
    private String date;
    private int cvv;
    private String email;

    public CreditCardClass(String holderName, String creditCardNumber, String date, int cvv, String email) {
        this.holderName = holderName;
        this.creditCardNumber = creditCardNumber;
        this.date = date;
        this.cvv = cvv;
        this.email = email;
    }




    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
