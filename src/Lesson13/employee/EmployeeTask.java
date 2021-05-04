package Lesson13.employee;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        Comparator<Employee> comparator1 = new Employee.NameComparator();
        Comparator<Employee> comparator2 = new Employee.NameComparator().thenComparing(new Employee.SalaryComparator());
        Comparator<Employee> comparator3 = new Employee.NameComparator().thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.AgeComparator()).thenComparing(new Employee.CompanyComparator());
        employees.sort(comparator1);
        employees.sort(comparator2);
        employees.sort(comparator3);

        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        // имени и зарплате
        // имени, зарплате, возрасту и компании
    }
}
