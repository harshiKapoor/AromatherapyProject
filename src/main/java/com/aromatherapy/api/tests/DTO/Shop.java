package com.aromatherapy.api.tests.DTO;

import java.util.ArrayList;

public class Shop {
    private String id;
    private String address;
    private String contact;
    private String email;
    private String phone;
    private ArrayList<String> timeslots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(ArrayList<String> timeslots) {
        this.timeslots = timeslots;
    }
}
