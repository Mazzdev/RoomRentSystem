package org.example.entity;

public class Reservation {
    private final Customer customer;
    private final Room room;
    private int numberOfHours;

    public Reservation(Customer customer, Room room, int numberOfHours) {
        this.customer = customer;
        this.room = room;
        if (numberOfHours > 12) {
            throw new IllegalArgumentException();
        }
        this.numberOfHours = numberOfHours;
    }


    public double totalPrice() {
        if (this.numberOfHours == 12) {
            return (this.room.pricePerHour() * this.numberOfHours) * 0.8;
        }
        return this.room.pricePerHour() * this.numberOfHours;
    }

}
