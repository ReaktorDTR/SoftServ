package com.softserv.test.test1;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class Rental {
    private int kind;
    private int days;

    // Other fields, constructors, get, set, etc.
    public Rental(int kind, int days) {
        this.kind = kind;
        this.days = days;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getBasePrice() {
        // Calculation of Price.
        // . . .
        return 1.0;
    }

    public double amountFor() {
        double result;
        // Another code.
        result = getDays() * getBasePrice();
        if (getKind() == 1) {
            result = result * 1.5;
        } else if (getKind() == 2) {
            result = result * 2;
        } else if (getKind() == 3) {
            result = result * 2.5;
        } else if (getDays() > 7) {
            result = result * 3;
        }
        // Other calculation.
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (days != rental.days) return false;
        if (kind != rental.kind) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kind;
        result = 31 * result + days;
        return result;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "kind=" + kind +
                ", days=" + days +
                '}';
    }
    // Other methods.
}
