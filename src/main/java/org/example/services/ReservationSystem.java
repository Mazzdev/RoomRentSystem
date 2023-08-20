package org.example.services;

import org.example.entity.Customer;
import org.example.entity.Reservation;
import org.example.entity.Room;

import java.util.List;

public class ReservationSystem {

    private List<Customer> customers;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public ReservationSystem(List<Customer> customers, List<Room> rooms) {
        this.customers = customers;
        this.rooms = rooms;
    }


    public void addRoom(String roomName, String address, double price, double area, boolean rented) {
        Room room = new Room(roomName, address, price, area, rented);
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public void rentRoom(Customer customer, Room room, int numberOfHours) {

        if(!room.isRented()){
            room.setRented(true);
            reservations.add(new Reservation(customer, room, numberOfHours));
        }
//
    }

//

    public void returnRoom(Room room) {
        if(room.isRented()){
            room.setRented(false);
        }
    }




}
