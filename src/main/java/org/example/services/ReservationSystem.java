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
            if (room.getRoomName().equals(name)) {
                roomToRemove = room;
                check = true;
                break;
            }
        }
        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
        }

        return check;

        if(check){
            System.out.println("Sala została usunięta");
        }else{
            System.out.println("Nie ma takiej sali!");
        }
    }

    public void rentRoom(String nameRoom, Customer customer) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomName().equals(nameRoom)) {
                room = r;
                break;
            }
        }

        if (room != null) {
            room.rent(customer);
        } else {
            System.out.println("Brak sali o podanej nazwie!");
        }
    }

    public void returnRoom(String nameRoom) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomName().equals(nameRoom)) {
                room = r;
                break;
            }
        }

        if (room != null) {
            room.give();
        } else {
            System.out.println("Nie ma sali o podanej nazwie.");
        }

    }

    public void addReservetionToHistory(Customer customer, Room room, int numberOfHours){
        reservations.add(new Reservation(customer, room, numberOfHours));
    }


}
