package com.ice.simplebanksite.model;

/**
 * Created by Bartek on 2016-12-22.
 */
public class Balance {
    private double balance;

    public Balance(){}
    public Balance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double changeBalance(double change)
    {
        balance += change;
        return balance;
    }
}
