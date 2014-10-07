package com.softserv.test.test2;

import java.util.Comparator;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class FixPaymentEmployees {
    private int id;
    private String name;
    private double salary;

    public FixPaymentEmployees(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }


    //Середньомісячна зарплата працівника з фіксованою оплатою праці, це щомісячна зарплата.
    public double averageMonthlySalary (){
        return salary;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + averageMonthlySalary();
    }


}
