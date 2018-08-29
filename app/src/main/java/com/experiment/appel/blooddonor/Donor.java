package com.experiment.appel.blooddonor;

public class Donor {

    private String bloodGroup,name,address,phoneNumber;



    public Donor(String bloodGroup, String name, String address, String phoneNumber) {
        this.bloodGroup = bloodGroup;
        this.name = name;
        this.address = address;
        this.phoneNumber=phoneNumber;

    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}