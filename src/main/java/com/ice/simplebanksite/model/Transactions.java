package com.ice.simplebanksite.model;

/**
 * Created by Bartek on 2016-12-18.
 */
public class Transactions {
    private int transID;
    private String user;
    private String accountAddress;
    private String description;
    private float amount;
    private int status = 0; // -1 - denied
                            // 0  - undecided
                            // 1  - accepted

    public Transactions(){}
    public Transactions(String user, String accountAddress, String description, float amount, int transID)
    {
        this.user = user;
        this.accountAddress = accountAddress;
        this.description = description;
        this.amount = amount;
        this.transID = transID;
    }

    public Transactions(String user, String accountAddress, String description, float amount, int status, int transID)
    {
        this.user = user;
        this.accountAddress = accountAddress;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.transID = transID;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString()
    {
        String s = "Transaction ID: "   + transID +
                    "\nUser Name: "       + user +
                    "\nAddress: "         + accountAddress +
                    "\nAmount: "          + amount +
                    "\nDescription: "     + description +
                    "\nStatus: "          + status;

        return s;
    }
}
