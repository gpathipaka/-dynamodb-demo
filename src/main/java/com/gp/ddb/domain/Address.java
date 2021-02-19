package com.gp.ddb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

@DynamoDBDocument
public class Address implements Serializable {

    private String addressLine1;
    private String addressLine2;
    private String state;
    private String city;
    private String zip;

    @DynamoDBAttribute
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @DynamoDBAttribute
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @DynamoDBAttribute
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @DynamoDBAttribute
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @DynamoDBAttribute
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
