package org.example.services;

import org.example.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;


public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public void rentRoom(Customer customer, Room room, String startTime, String endTime) {
        LocalTime parsedStartTime = LocalTime.parse(startTime);
        LocalTime parsedEndTime = LocalTime.parse(endTime);

        if (isRoomAvailable(room, parsedStartTime, parsedEndTime)) {
            Reservation reservation = new Reservation(customer, room, parsedStartTime, parsedEndTime);
            reservations.add(reservation);
        } else {
            throw new IllegalArgumentException("The room is already booked during the specified time.");
        }
    }

    public void returnRoom(Room room) {
        reservations.removeIf(reservation -> reservation.getRoom().equals(room));
    }

    private boolean isRoomAvailable(Room room, LocalTime startTime, LocalTime endTime) {
        for (Reservation existingReservation : reservations) {
            if (existingReservation.getRoom().equals(room)) {
                if (startTime.isBefore(existingReservation.getEndTime())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}