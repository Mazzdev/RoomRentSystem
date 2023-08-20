package org.example.entity;

public record Customer(String name, String surname) {

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
