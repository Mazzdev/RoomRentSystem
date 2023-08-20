package org.example.entity;

public class Room {
    private String roomName;
    private String address;
    private double pricePerHours;
    private double area;
    private boolean rented;

    public Room(String roomName, String address, double pricePerHours, double area) {
        this.roomName = roomName;
        this.address = address;
        this.pricePerHours = pricePerHours;
        this.area = area;
        this.rented = false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", address='" + address + '\'' +
                ", pricePerHours=" + pricePerHours +
                ", area=" + area +
                ", rented=" + rented +
                '}';
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPricePerHour() {
        return pricePerHours;
    }

    public void setPricePerHour(double pricePerHours) {
        this.pricePerHours = pricePerHours;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
