package org.example;

public class Room {
    private final String nameRoom;
    private final String address;
    private final double price;
    private final double area;
    private  boolean isRented;
    private String borrower;

    public Room(String nameRoom, String address, double price, double area) {
        this.nameRoom = nameRoom;
        this.address = address;
        this.price = price;
        this.area = area;
        this.isRented = false;
        this.borrower = null;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public double getPrice() {
        return price;
    }


    public String getAddress() {
        return address;
    }

    public boolean isRented() {
        return isRented;
    }

    public double getArea() {
        return area;
    }

    public String getBorrower() {
        return borrower;
    }

    public void rent(String personName){
        if(!isRented){
            isRented = true;
            borrower = personName;
            System.out.println("Sala została wypożyczona dla: " + personName);
        } else {
            System.out.println("Sala jest już wypożyczona.");
        }
    }

    public void give(){
        if(isRented){
            isRented = false;
            borrower= null;
            System.out.println("Sala została zwolniona");
        }else {
            System.out.println("Sala nie jest wypożyczona.");
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + nameRoom + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
