package org.example.entity;

import java.util.ArrayList;

public class Room {
    private final String roomName;
    private final String address;
    private final double pricePerHour;
    private final double area;
    private boolean isRented;
    private Customer customer;
    private ArrayList<Reservation> reservations;

    public Room(String roomName, String address, double pricePerHour, double area) {
        this.roomName = roomName;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.area = area;
        this.isRented = false;
        this.customer = null;
        this.reservations = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }


    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getAddress() {
        return address;
    }

    public boolean isRented() {
        return isRented;
    }

    public double getArea() {
        return area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean rent(Customer customer) {
        if (!isRented) {
            isRented = true;
            this.customer = customer;

            return true;
        }
        return false;
    }

    public boolean give() {
        if (isRented) {
            isRented = false;
            this.customer = null;
            return true;
        }
        return false;
    }
}
