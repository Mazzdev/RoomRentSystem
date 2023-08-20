package org.example.services;

import org.example.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String name, String surname) {
        Customer customer = new Customer(name, surname);
        customers.add(customer);
    }

    public void removeCustomer(String name, String surname) {
        Customer customerToRemove = null;
        boolean check = false;
        for (Customer customer : customers) {
            if (customer.name().equals(name) && customer.surname().equals(surname)) {
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
}
