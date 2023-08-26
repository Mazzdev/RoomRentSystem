package org.example.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private final Customer customer;
    private final Room room;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    private static final LocalTime MIN_BOOKING_TIME = LocalTime.of(10, 0);
    private static final LocalTime MAX_BOOKING_TIME = LocalTime.of(22, 0);

    public Reservation(Customer customer, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.customer = customer;
        this.room = room;

        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be earlier than start time.");
        }

        if (startTime.toLocalTime().isBefore(MIN_BOOKING_TIME) || endTime.toLocalTime().isAfter(MAX_BOOKING_TIME)) {
            throw new IllegalArgumentException("Booking hours are between 10:00 and 22:00.");
        }

        this.startTime = startTime;
        this.endTime = endTime;

        if (getNumberOfHours() > 12) {
            throw new IllegalArgumentException("Reservation duration cannot exceed 12 hours.");
        }
    }

    public double totalPrice() {
        if (this.getNumberOfHours() == 12) {
            return (this.room.pricePerHour() * this.getNumberOfHours()) * 0.8;
        }
        return this.room.pricePerHour() * this.getNumberOfHours();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public long getNumberOfHours() {
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
