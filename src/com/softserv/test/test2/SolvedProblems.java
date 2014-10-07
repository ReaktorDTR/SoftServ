package com.softserv.test.test2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Reaktor on 07.10.2014.
 */
public class SolvedProblems {
    public static void main(String[] args) throws IOException {
        ArrayList<FixPaymentEmployees> employees = new ArrayList<FixPaymentEmployees>();
        // Тестовий набір даних.
        employees.add(new FixPaymentEmployees(1, "Ivan", 1500));
        employees.add(new HourlyWageEmployees(2, "Kolya", 5));
        employees.add(new FixPaymentEmployees(3, "Grisha", 2000));
        employees.add(new FixPaymentEmployees(4, "Marina", 3000));
        employees.add(new HourlyWageEmployees(5, "Tanya", 10));
        employees.add(new HourlyWageEmployees(6, "Sveta", 7));
        employees.add(new FixPaymentEmployees(7, "Sasha", 700));
        employees.add(new FixPaymentEmployees(8, "Anya", 3000));
        //Вивід колекції працівників.
        for (FixPaymentEmployees element : employees) {
            System.out.println(element);
        }

        System.out.println("Problem a) Sort the collection of employees in descending order by the average monthly salary. In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.");
        //Сортування колекції по середній заробітній платі у порядку спадання, якщо зарплати співпадають, то відсортовується по імені.
        Comparator<FixPaymentEmployees> comparator = new Comparator<FixPaymentEmployees>() {
            @Override
            public int compare(FixPaymentEmployees o1, FixPaymentEmployees o2) {
                if (o1.averageMonthlySalary() > o2.averageMonthlySalary()) return -1;
                if (o1.averageMonthlySalary() < o2.averageMonthlySalary()) return 1;
                if (o1.averageMonthlySalary() == o2.averageMonthlySalary()) {
                    return o1.getName().compareTo(o2.toString());
                }
                return 0;
            }
        };
        Collections.sort(employees, comparator);
        //Вивід відсортованої колекції
        for (FixPaymentEmployees element : employees) {
            System.out.println(element);
        }

        System.out.println("Problem b) Write information about first five employees from collection (problem a).");
        //Вивід першої п"ятірки з колекції працівників
        ArrayList<FixPaymentEmployees> employeesB = new ArrayList<FixPaymentEmployees>();
        for (int i = 0; i < 5; i++) {
            System.out.println(employees.get(i));
            employeesB.add(employees.get(i));
        }

        System.out.println("Problem c) Write ID of three last employees from collection (problem b).");
        //Вивід останніх трьох з пятірки перших працівників.
        for (int i = employeesB.size() - 1; i > employeesB.size() - 1 - 3; i--) {
            System.out.println(employeesB.get(i));
        }

        System.out.println("Problem d) Write code for reading and writing collection of these objects from (into) file.");
        System.out.println("Problem e) Write code for handling the incorrect format of incoming file.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Введення імені файла для запису даних колекції працівників
        System.out.println("write filename of output stream");
        String outputFile = reader.readLine();
        //Запис даних в файл, якщо працівник має фіксовану зарплату - додається префікс "Fix", для працівника з погодинною оплатою - "Hourly"
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(outputFile));
        for (FixPaymentEmployees element : employees) {
            String prefix = "";
            if (element.getClass().equals(FixPaymentEmployees.class)) prefix = "Fix";
            if (element.getClass().equals(HourlyWageEmployees.class)) prefix = "Hourly";
            outputStream.write(element.getId() + " " + element.getName() + " " + element.getSalary() + " " + prefix + "\r\n");
        }
        outputStream.close();

        //Введення імені файла для зчитування даних колекції працівників
        System.out.println("write filename of input stream");
        String inputFile = reader.readLine();
        reader.close();
        BufferedReader inputStream = null;
        try {
             inputStream = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        //Очищення колекції перед зчитуванням з файла
        employees.clear();

        //Зчитування даних з файла
        while (inputStream.ready()) {
            String fullString = inputStream.readLine();
            reader.close();
            //Розділення параметрів
            String[] param = fullString.split(" ");
            //Аналіз параметрів і занесення їх в колекцію працівників, при виникненні помилок виводиться повідомлення "Wrong file format!".
            if (param.length == 4) {
                try {
                    if (param[3].equals("Fix")) {
                        employees.add(new FixPaymentEmployees(Integer.parseInt(param[0]), param[1], Double.parseDouble(param[2])));
                    } else if (param[3].equals("Hourly")) {
                        employees.add(new HourlyWageEmployees(Integer.parseInt(param[0]), param[1], Double.parseDouble(param[2])));
                    } else {
                        System.out.println("Wrong file format!");
                        employees.clear();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong file format!");
                    employees.clear();
                    break;
                }
            } else {
                System.out.println("Wrong file format!");
                employees.clear();
                break;
            }
        }
        inputStream.close();
        //Вивід даних які зчитано з файла
        for (FixPaymentEmployees element : employees) {
            System.out.println(element);
        }
    }
}
