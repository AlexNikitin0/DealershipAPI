package com.pluralsight.models;

import java.time.LocalDate;

public abstract class Contract {
    protected String customerName,email;
    protected String carSold;
    protected double totalPrice,monthlyPayment;
    protected LocalDate date;
    //constructor

    public Contract(LocalDate date, String customerName, String email, String carSold) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.carSold = carSold;

    }




    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarSold() {
        return carSold;
    }

    public void setCarSold(String carSold) {
        this.carSold = carSold;
    }

    abstract double getTotalPrice();
    abstract double getMonthlyPayment();

}
