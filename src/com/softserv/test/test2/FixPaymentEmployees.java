package com.softserv.test.test2;

import java.io.Serializable;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class FixPaymentEmployees implements Serializable, Comparable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FixPaymentEmployees)) return false;

        FixPaymentEmployees that = (FixPaymentEmployees) o;

        if (id != that.id) return false;
        if (Double.compare(that.salary, salary) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    //Сортування колекції по середній заробітній платі у порядку спадання, якщо зарплати співпадають, то відсортовується по імені.
    public int compareTo(Object o) {
        FixPaymentEmployees employees = (FixPaymentEmployees) o;
        if (averageMonthlySalary() > employees.averageMonthlySalary()) {
            return -1;
        } else if (averageMonthlySalary() < employees.averageMonthlySalary()) {
            return 1;
        } else if (averageMonthlySalary() == employees.averageMonthlySalary()) {
            return getName().compareTo(employees.toString());
        }
        return 0;
    }
}
