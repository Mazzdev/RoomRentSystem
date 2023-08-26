package org.example.services;

import org.example.entity.Customer;
import org.example.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Room> rooms;

    public RoomService() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(String roomName, String address, double price, double area) {
        Room room = new Room(roomName, address, price, area);
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Room findRoomByName(String name) {
        for (Room room : rooms) {
            if (room.roomName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
