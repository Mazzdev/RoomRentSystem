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


    public void addRoom(String name, String address, double price, double area) {
        Room room = new Room(name, address, price, area);
        rooms.add(room);
    }

    public boolean removeRoom(String name) {
        Room roomToRemove = null;
        boolean check = false;
        for (Room room : rooms) {
            if (room.getNameRoom().equals(name)) {
                roomToRemove = room;
                check = true;
                break;
            }
        }
        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
        }

        return check;
    }

    public void addReservetionToHistory(Customer customer, Room room, int numberOfHours){
        reservations.add(new Reservation(customer, room, numberOfHours));
    }


}
