package com.experiment.appel.blooddonor;

public class Donor {

    private String bloodGroup,name,address;

    public Donor(String bloodGroup, String name, String address) {
        this.bloodGroup = bloodGroup;
        this.name = name;
        this.address = address;
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
}
