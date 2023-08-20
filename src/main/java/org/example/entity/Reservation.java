package org.example.entity;

public class Reservation {
    private Customer customer;
    private Room room;
    private int numberOfHours;

    public Reservation(Customer customer, Room room, int numberOfHours) {
        this.customer = customer;
        this.room = room;
        this.numberOfHours = numberOfHours;
    }

    //liczenie ceny za wynajem


}
