package org.example.services;

import org.example.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public void rentRoom(Customer customer, Room room, String startDateTimeString, String endDateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeString, formatter);

        if (isRoomAvailable(room, startDateTime)) {
            Reservation reservation = new Reservation(customer, room, startDateTime, endDateTime);
            reservations.add(reservation);
        } else {
            throw new IllegalArgumentException("The room is already booked during the specified time.");
        }
    }

    public void returnRoom(Room room) {
        reservations.removeIf(reservation -> reservation.getRoom().equals(room));
    }

    private boolean isRoomAvailable(Room room, LocalDateTime startDateTime) {
        for (Reservation existingReservation : reservations) {
            if (existingReservation.getRoom().equals(room)) {
                if (startDateTime.isBefore(existingReservation.getEndTime())) {
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