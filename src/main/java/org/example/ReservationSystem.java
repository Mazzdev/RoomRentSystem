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
        boolean check = false;
        for (Room room : rooms) {
            if (room.getNameRoom().equals(name)) {
                roomToRemove = room;
                check = true;
                break;
            }
        }
        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
        }

        if(check){
            System.out.println("Sala została usunięta");
        }else{
            System.out.println("Nie ma takiej sali!");
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

    public void addCustomer(String name, String surname) {
        Customer customer = new Customer(name, surname);
        customers.add(customer);
    }

    public void removeCustomer(String name, String surname) {
        Customer customerToRemove = null;
        boolean check = false;
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getSurname().equals(surname)) {
                customerToRemove = customer;
                check = true;
                break;
            }
        }

        if (customerToRemove != null) {
            customers.remove(customerToRemove);
        }

        if(check){
            System.out.println("Klient został usunięty z listy.");
        }else {
            System.out.println("Nie ma takiego klienta na liście!");
        }
    }

    public void displayAllCustomers() {
        System.out.println("Lista klientów: ");
        for (Customer customer : customers) {
            System.out.println("Imię: " + customer.getName() + ", Nazwisko: " + customer.getSurname());
        }
    }
}
