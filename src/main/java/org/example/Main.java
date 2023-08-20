package org.example;

import org.example.entity.*;
import org.example.services.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();


        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();



        Customer customer1 = new Customer("Adam", "Kowalski");
        Customer customer2 = new Customer("Michał", "Patec");
        Customer customer3 = new Customer("Maks", "Okoń");
        Customer customer4 = new Customer("Paweł", "Ryba");
        Customer customer5 = new Customer("Damian", "Wilk");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        Room room1 = new Room("Sala nr 1", "1", 50, 45);
        Room room2 = new Room("Sala nr 2", "2", 100, 200);
        Room room3 = new Room("Sala nr 3", "3", 30, 35);
        Room room4 = new Room("Sala nr 4", "4", 100, 200);
        Room room5 = new Room("Sala nr 5", "5", 25, 25);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        ReservationSystem reservationSystem = new ReservationSystem(customers, rooms);
        CustomerService customerService = new CustomerService();
        RoomService roomService = new RoomService(rooms);

        displayAllRooms(rooms);
        System.out.println();
        displayAllCustomers(customers);

        System.out.println();

        System.out.println("Dodanie klienta:");
        customerService.addCustomer("Marek", "Wiatr");
        displayAllCustomers(customers);

        System.out.println();

        System.out.println("Dodanie sali: ");
        roomService.addRoom("Sala6", "Sala nr 7", 130, 25);
        displayAllRooms(rooms);

        System.out.println();

        System.out.println("Usunięcie Klienta: ");
        customerService.removeCustomer("Maks", "Okoń");
        customerService.removeCustomer("Stefan", "Witczak");
        displayAllCustomers(customers);

        System.out.println();

        System.out.println("Usunięcie Sali: ");
        roomService.removeRoom(room1);
        roomService.removeRoom(room5);
        displayAllRooms(rooms);

        System.out.println();

        System.out.println("Wynajęcie sali: ");
        reservationSystem.rentRoom(customer1, room2, 30);
        reservationSystem.rentRoom(customer2, room3, 130);
        reservationSystem.rentRoom(customer3, room4, 230);
        displayAllRooms(rooms);

        System.out.println();

        System.out.println("Zwrócenie sali:");

        reservationSystem.returnRoom(room2);
        reservationSystem.returnRoom(room4);
        displayAllRooms(rooms);


    }

    public static void displayAllRooms(List<Room> rooms) {
        System.out.println("Dostępne sale: ");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }


    public static void displayAllCustomers(List<Customer> customers) {
        System.out.println("Lista klientów: ");
        for (Customer customer : customers) {
            System.out.println("Imię: " + customer.name() + ", Nazwisko: " + customer.surname());
        }
    }

    //Metody wyświetlające komunikaty"
    public static void removeRoomInformation() {


    }

}