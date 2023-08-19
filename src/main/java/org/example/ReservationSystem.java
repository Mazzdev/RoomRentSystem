package org.example;

import java.util.List;
import java.util.Map;

public class ReservationSystem {

    private List<Customer> customers;
    private List<Room> rooms;

    public ReservationSystem(List<Customer> customers, List<Room> rooms) {
        this.customers = customers;
        this.rooms = rooms;
    }


    public void addRoom(String name, String address, double price, double area) {
        Room room = new Room(name, address, price, area);
        rooms.add(room);
    }

    public void removeRoom(String name) {
        Room roomToRemove = null;
        for (Room room : rooms) {
            if (room.getNameRoom().equals(name)) {
                roomToRemove = room;
                break;
            }
        }
        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
        }
    }

    public void rentRoom(String nameRoom, Customer customer) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getNameRoom().equals(nameRoom)) {
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
            if (r.getNameRoom().equals(nameRoom)) {
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

    public void displayAllRooms() {
        System.out.println("Dostępne sale: ");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }


}
