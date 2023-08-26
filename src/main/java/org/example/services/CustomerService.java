package org.example.services;

import org.example.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;
    private int nextId = 1;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String name, String surname) {
        Customer customer = new Customer(nextId, name, surname);
        customers.add(customer);
        nextId++;
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.id() == id) {
                return customer;
            }
        }
        return null;
    }



    public List<Customer> getCustomers() {
        return customers;
    }
}
