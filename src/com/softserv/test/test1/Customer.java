package com.softserv.test.test1;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class Customer {
    private String name;

    // Other fields, constructors, get, set, etc.
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Other methods.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}



