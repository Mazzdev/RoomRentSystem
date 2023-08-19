package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        ReservationSystem reservationSystem = new ReservationSystem(customers, rooms);

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

        reservationSystem.displayAllRooms();
        System.out.println();
        reservationSystem.displayAllCustomers();

        System.out.println();

        System.out.println("Dodanie klienta:");
        reservationSystem.addCustomer("Marek", "Wiatr");
        reservationSystem.displayAllCustomers();

        System.out.println();

        System.out.println("Dodanie sali: ");
        reservationSystem.addRoom("Sala nr 6", "6", 125, 50);
        reservationSystem.displayAllRooms();

        System.out.println();

        System.out.println("Usunięcie Klienta: ");
        reservationSystem.removeCustomer("Maks", "Okoń");
        reservationSystem.removeCustomer("Stefan", "Witczak");
        reservationSystem.displayAllCustomers();

        System.out.println();

        System.out.println("Usunięcie Sali: ");
        reservationSystem.removeRoom("Sala nr 2");
        reservationSystem.removeRoom("Sala nr 26");
        reservationSystem.displayAllRooms();

        System.out.println();

        System.out.println("Wynajęcie sali: ");
        reservationSystem.rentRoom("Sala nr 5", customer1);
        reservationSystem.rentRoom("Sala nr 5", customer2);
        reservationSystem.rentRoom("Sala nr 23", customer1);
        reservationSystem.displayAllRooms();

        System.out.println();

        System.out.println("Zwrócenie sali:");
        reservationSystem.returnRoom("Sala nr 5");
        reservationSystem.returnRoom("Sala nr 5");
        reservationSystem.returnRoom("Sala nr 26");
        reservationSystem.displayAllRooms();




    }
}