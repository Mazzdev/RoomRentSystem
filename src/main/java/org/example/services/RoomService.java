package org.example.services;

import org.example.entity.Customer;
import org.example.entity.Room;

import java.util.List;

public class RoomService {
    private List<Room> rooms;
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
}
