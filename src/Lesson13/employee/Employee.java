package Lesson13.employee;


import Lesson13.employee.utils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры

    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null || company.length() < 3) throw new IllegalArgumentException("company < 3");
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 12792) throw new IllegalArgumentException("Зарплата не может быть меньше 12792");
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 21) throw new IllegalArgumentException("Возраст не может быть меньше 21");
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[Randoms.getRandomInt(names.length)],
                    companies[Randoms.getRandomInt(companies.length)], Randoms.getRandomInt(20000, 150000),
                    Randoms.getRandomInt(21, 60) )); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    public static class NameComparator implements Comparator<Employee> {


        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }

    public static class CompanyComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.company.compareToIgnoreCase(o2.company);
        }
    }

    public static class AgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }

    public static class SalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.salary, o2.salary);
        }
    }

}