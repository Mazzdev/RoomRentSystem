package org.example.entity;



import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String nameRoom;
    private final String address;
    private final double pricePerHour;
    private final double area;
    private boolean isRented;
    private Customer customer;
    private List<Reservation>  reservations;

    public Room(String nameRoom, String address, double pricePerHour, double area) {
        this.nameRoom = nameRoom;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.area = area;
        this.isRented = false;
        this.customer = null;
        this.reservations = new ArrayList<>();
    }

    public String getNameRoom() {
        return nameRoom;
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

    public void rent(Customer customer) {
        if (!isRented) {
            isRented = true;
            customer = customer;
            System.out.println("Sala została wypożyczona dla: " + customer);
        } else {
            System.out.println("Sala jest już wypożyczona.");
        }
    }

    public void give() {
        if (isRented) {
            isRented = false;
            customer = null;
            System.out.println("Sala została zwolniona");
        } else {
            System.out.println("Sala nie jest wypożyczona.");
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameRoom='" + nameRoom + '\'' +
                ", address='" + address + '\'' +
                ", price=" + pricePerHour +
                ", area=" + area +
                ", isRented=" + isRented +
                ", customer=" + customer +
                '}';
    }
}
