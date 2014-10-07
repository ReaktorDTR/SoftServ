package com.softserv.test.test2;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class HourlyWageEmployees extends FixPaymentEmployees {
    public HourlyWageEmployees(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    //Середньомісячна зарплата працівника з погодинною оплатою праці обраховується за формулою (20.8 * 8 * погодинна ставка)
    public double averageMonthlySalary() {
        double ams = 20.8 * 8 * getSalary();
        return ams;
    }
}
