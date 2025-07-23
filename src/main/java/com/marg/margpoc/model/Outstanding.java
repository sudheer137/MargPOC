package com.marg.margpoc.model;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "Outstanding")
public class Outstanding {


    private String retailerName;
    private String contactNumber;
    private String address;
    private String city;
    private String state;
    private String outstandingBalance;
/*
    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;

    }
    public void setOutstandingBalance(String outstandingBalance) {

        this.outstandingBalance = outstandingBalance;

    }


    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


 */
}
