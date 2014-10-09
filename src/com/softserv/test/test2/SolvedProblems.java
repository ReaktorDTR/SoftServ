package com.softserv.test.test2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class SolvedProblems {
    public static void main(String[] args) throws IOException {
        List<FixPaymentEmployees> employees = new ArrayList<FixPaymentEmployees>();
        List<FixPaymentEmployees> employeesB = new ArrayList<FixPaymentEmployees>();
        employees = fileToCollection();
        //Вивід даних які зчитано з файла
        if (!employees.isEmpty()) {
            printEmployees(employees);

            System.out.println("Problem a) Sort the collection of employees in descending order by the average monthly salary. In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.");
            sortEmployees(employees);

            System.out.println("Problem b) Write information about first five employees from collection (problem a).");
            employeesB = firstFiveEmployees(employees);
            System.out.println("Problem c) Write ID of three last employees from collection (problem b).");
            threeOfFive(employeesB);

            System.out.println("Problem d) Write code for reading and writing collection of these objects from (into) file.");
            System.out.println("Problem e) Write code for handling the incorrect format of incoming file.");

            collectionToFile(employees);
        }
    }

    //Зчитування даних колекції працівників з файла
    public static List<FixPaymentEmployees> fileToCollection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FixPaymentEmployees> employeeses = new ArrayList<FixPaymentEmployees>();
        //Введення імені файла
        System.out.println("Write filename of input stream");
        String inputFile = reader.readLine();
        //Зчитування даних з файла
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFile))) {
            employeeses = (ArrayList<FixPaymentEmployees>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (Exception e) {
            System.out.println("Incorrect format file!");
        }
        return employeeses;
    }

    //Запис даних колекції працівників в файл
    public static void collectionToFile(List<FixPaymentEmployees> employees) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Введення імені файла для
        System.out.println("Write filename of output stream");
        String outputFile = reader.readLine();
        reader.close();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            outputStream.writeObject(employees);
        }
    }

    //Вивід останніх трьох з пятірки працівників.
    public static void threeOfFive(List<FixPaymentEmployees> employees) {
        for (int i = employees.size() - 1; i > employees.size() - 1 - 3; i--) {
            System.out.println("id = " + employees.get(i).getId());
        }
    }

    //Вивід першої п"ятірки з колекції працівників
    public static List<FixPaymentEmployees> firstFiveEmployees(List<FixPaymentEmployees> employees) {
        List<FixPaymentEmployees> employeesTemp = new ArrayList<FixPaymentEmployees>();
        for (int i = 0; i < 5; i++) {
            System.out.println(employees.get(i));
            employeesTemp.add(employees.get(i));
        }
        return employeesTemp;
    }

    //Сортування колекції по середній заробітній платі у порядку спадання, якщо зарплати співпадають, то відсортовується по імені.
    public static void sortEmployees(List<FixPaymentEmployees> employees) {
        Collections.sort(employees);
        //Вивід відсортованої колекції
        printEmployees(employees);
    }

    //Вивід колекції працівників.
    public static void printEmployees(List<FixPaymentEmployees> employees) {
        for (FixPaymentEmployees element : employees) {
            System.out.println(element);
        }
    }
}
