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

    public void removeCustomer(Customer customer) {
        customer.remove(customer);
    }

    public Customer findCustomerByName(String firstName, String lastName) {
        for (Customer customer : customers) {
            if (customer.name().equals(firstName + " " + lastName)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
