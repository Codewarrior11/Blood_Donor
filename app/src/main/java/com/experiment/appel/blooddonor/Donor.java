package com.experiment.appel.blooddonor;

public class Donor {
    private  int id;
    String name,age,gender,address,contactNo,bloodGroup,lastDonationDate;

    public Donor(int id, String name, String age, String gender, String address, String contactNo, String bloodGroup, String lastDonationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contactNo = contactNo;
        this.bloodGroup = bloodGroup;
        this.lastDonationDate = lastDonationDate;
    }

    public Donor(String name, String age, String gender, String address, String contactNo, String bloodGroup, String lastDonationDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contactNo = contactNo;
        this.bloodGroup = bloodGroup;
        this.lastDonationDate = lastDonationDate;
    }

    public Donor(String bloodGroup, String name, String address, String contactNo) {
        this.bloodGroup = bloodGroup;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getLastDonationDate() {
        return lastDonationDate;
    }
}
