package org.example;

public class Room {
    private String name;
    private String address;
    private double price;
    private double area;
    private boolean isRented;

    public Room(String name, String address, double price, double area, boolean isRented) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
        this.isRented = isRented;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", area=" + area +
                '}';
    }
}
