package org.example;

import org.example.entity.Customer;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.services.CustomerService;
import org.example.services.ReservationService;
import org.example.services.RoomService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ReservationService reservationService = new ReservationService();
        CustomerService customerService = new CustomerService();
        RoomService roomService = new RoomService();
        Scanner scanner = new Scanner(System.in);

        createCustomers(customerService);
        createRooms(roomService);

        int choiceOne;
        int choiceTwo;
        int choiceThree;
        int choiceMain;
        String roomName;
        String address;
        String name;
        String surname;
        String startDate;
        String endDate;
        double pricePerHour;
        double area;


        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Zarządzanie salami");
            System.out.println("2. Strefa klienta");
            System.out.println("3. Rezerwacje");
            System.out.println("0. Wyjscie");

            System.out.print("\nWybrana opcja: ");
            choiceMain = scanner.nextInt();

            switch (choiceMain) {


                case 1:
                    do {
                        scanner.nextLine();

                        System.out.println("--- ZARZĄDZANIE SALAMI ---");
                        System.out.println("1. Dodaj Salę.");
                        System.out.println("2. Usuń Salę.");
                        System.out.println("3. Wyświetl listę wszystkich sal.");
                        System.out.println("0. Powrót.");


                        System.out.print("\nWybrana opcja: ");
                        choiceOne = scanner.nextInt();

                        switch (choiceOne) {
                            case 1:
                                scanner.nextLine();

                                System.out.println("\n--- DODAWANIE SALI ---\n");

                                System.out.print("Podaj nazwę sali: ");
                                roomName = scanner.nextLine();

                                System.out.print("\n Podaj adres sali: ");
                                address = scanner.nextLine();

                                System.out.print("\n Podaj kwotę za godzinę wynajęcia: ");
                                pricePerHour = scanner.nextDouble();

                                System.out.print("\n Podaj powierzchnie sali: ");
                                area = scanner.nextDouble();

                                roomService.addRoom(roomName, address, pricePerHour, area);
                                break;

                            case 2:
                                scanner.nextLine();

                                System.out.println("\n--- Usuwanie Sali ---\n");

                                System.out.print("Podaj nazwę sali do usunięcia: ");
                                roomName = scanner.nextLine();
                                Room roomToRemove = roomService.findRoomByName(roomName);

                                if (roomToRemove != null) {
                                    roomService.removeRoom(roomToRemove);
                                }
                                break;

                            case 3:
                                displayAllRooms(roomService);
                                break;
                            case 0:
                                System.out.println("\n--- POWRÓT DO POPRZEDNIEJ SEKCJI ---\n");
                                break;


                            default:
                                printDefaultInformation();
                                break;
                        }


                    } while (choiceOne != 0);

                    break;

                case 2:
                    do {
                        scanner.nextLine();

                        System.out.println("--- STREFA KLIENTA ---");
                        System.out.println("1. Dodaj Klienta.");
                        System.out.println("2. Usuń klienta.");
                        System.out.println("3. Wyświetl klienta.");
                        System.out.println("0. Powrót.");

                        System.out.print("\nWybrana opcja: ");
                        choiceTwo = scanner.nextInt();

                        switch (choiceTwo) {

                            case 1:
                                scanner.nextLine();

                                System.out.println("\n--- DODAWANIA KLIENTA ---");
                                System.out.print("Podaj imię: ");
                                name = scanner.nextLine();
                                System.out.print("\nPodaj nazwisko: ");
                                surname = scanner.nextLine();


                                customerService.addCustomer(name, surname);
                                break;

                            case 2:
                                scanner.nextLine();

                                System.out.println("\n--- USUWANIE KLIENTÓW ---\n");
                                System.out.print("Podaj imię: ");
                                name = scanner.nextLine();
                                scanner.nextLine();

                                System.out.print("\nPodaj nazwisko: ");
                                surname = scanner.nextLine();

                                Customer customerToRemove = customerService.findCustomerByName(name, surname);
                                if (customerToRemove != null) {
                                    customerService.removeCustomer(customerToRemove);
                                    System.out.println("Klient usunięty pomyślnie");
                                } else {
                                    System.out.println("Klient nie znaleziony!");
                                }
                                break;

                            case 3:
                                displayAllCustomers(customerService);
                                break;

                            case 0:
                                System.out.println("\n--- POWRÓT DO POPRZEDNIEJ SEKCJI ---\n");

                                break;

                            default:
                                printDefaultInformation();
                                break;
                        }


                    } while (choiceTwo != 0);

                    break;

                case 3:
                    do {
                        System.out.println("--- REZERWACJE ---");
                        System.out.println("1. Wyświetl listę rezerwacji.");
                        System.out.println("2. Zarezerwuj salę.");
                        System.out.println("3. Zwróć salę.");
                        System.out.println("0. Powrót");

                        System.out.print("\nWybrana opcja: ");
                        choiceThree = scanner.nextInt();

                        switch (choiceThree) {
                            case 1:
                                System.out.println("\n--- LISTA REZERWACJI --- \n");
                                displayAllReservations(reservationService);

                                break;

                            case 2:
                                scanner.nextLine();

                                System.out.println("\n--- REZERWACJA SALI ---\n");
                                System.out.print("\nPodaj imię klienta, który  rezerwuje salę: ");
                                name = scanner.nextLine();
                                System.out.print("\nPodaj nazwisko klienta, który  rezerwuje salę: ");
                                surname = scanner.nextLine();
                                Customer clientRentingTheRoom = customerService.findCustomerByName(name, surname);

                                System.out.print("\nPodaj nazwę rezerwowanej sali: ");
                                roomName = scanner.nextLine();
                                Room roomRented = roomService.findRoomByName(roomName);

                                System.out.print("\nRezerwacja od(data i godzina): ");
                                startDate = scanner.nextLine();

                                System.out.print("\nRezerwacja do(data i godzina): ");
                                endDate = scanner.nextLine();

                                reservationService.rentRoom(clientRentingTheRoom, roomRented, startDate, endDate);

                                break;

                            case 3:
                                scanner.nextLine();

                                System.out.println("\n--- ZWRACANIE SALI --- \n");
                                System.out.print("\nPodaj nazwę zwracanej sali sali: ");
                                roomName = scanner.nextLine();
                                Room roomReturned = roomService.findRoomByName(roomName);

                                reservationService.returnRoom(roomReturned);

                                break;
                            case 0:
                                System.out.println("\n--- POWRÓT DO POPRZEDNIEJ SEKCJI ---\n");

                                break;

                            default:
                                printDefaultInformation();
                                break;
                        }


                    } while (choiceThree != 0);

                    break;

                case 0:
                    System.out.println("--- WYJSCIĘ Z PROGRAMU ---");
                    break;


                default:
                    printDefaultInformation();

                    break;


            }
        } while (choiceMain != 0);


    }

    public static void displayAllRooms(RoomService roomService) {
        int counter = 1;
        System.out.println("Lista wszystkich sal: ");
        for (Room room : roomService.getRooms()) {
            System.out.println(counter + ". Nazwa Sali: " + room.roomName() +
                    ", Adres Sali: " + room.address() +
                    ", Cena za godzinę wynajęcia: " + room.pricePerHour() +
                    ", Powierzchnia: " + room.area());
            counter++;
        }
        System.out.println();
    }


    public static void displayAllCustomers(CustomerService customerService) {
        int counter = 1;
        System.out.println("Lista klientów: ");
        for (Customer customer : customerService.getCustomers()) {
            System.out.println(counter + ". Imię: " + customer.name() + ", Nazwisko: " + customer.surname());
            counter++;
        }
        System.out.println();
    }


    private static void displayAllReservations(ReservationService reservationService) {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservationService.getReservations()) {
            System.out.println("Customer: " + reservation.getCustomer().name() +
                    ", Room: " + reservation.getRoom().roomName() +
                    ", Start Time: " + reservation.getStartTime() +
                    ", End Time: " + reservation.getEndTime());
        }
    }

    public static void createRooms(RoomService roomService) {
        roomService.addRoom("Room 101", "1", 120, 80);
        roomService.addRoom("Room 202", "2", 160, 100);
        roomService.addRoom("Room 303", "3", 80, 60);
        roomService.addRoom("Room 404", "4", 200, 120);
        roomService.addRoom("Room 505", "5", 240, 140);

    }

    public static void createCustomers(CustomerService customerService) {
        customerService.addCustomer("Adam", "Kowalski");
        customerService.addCustomer("Michał", "Patec");
        customerService.addCustomer("Maks", "Okoń");
        customerService.addCustomer("Paweł", "Ryba");
        customerService.addCustomer("Damian", "Wilk");

    }

    public static void printDefaultInformation() {
        System.out.println("Nie ma takiej opcji! Wybierz jeszcze raz");
    }


    //Metody wyświetlające komunikaty"
    public static void removeRoomInformation() {


    }

}