package org.example.services;

import org.example.entity.Customer;
import org.example.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Room> rooms;

    public RoomService(List<Room> rooms) {
        this.rooms = new ArrayList<>();
    }


}
