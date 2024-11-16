package org.softwaretechnologies;

import org.softwaretechnologies.employee.Employee;
import org.softwaretechnologies.employee.EmployeeType;

import java.util.ArrayList;
import java.util.List;


public class Company {
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Создает и добавляет сотрудника в коллекцию employeeList.
     * @param name имя работника
     * @param baseSalary базовая зарплата сотрудника
     * @param type тип работника
     */
    public void addEmployee(String name, int baseSalary, EmployeeType type) {
        Employee employee = switch (type) {
            case Manager -> new Employee.Manager(name, baseSalary);
            case Programmer -> new Employee.Programmer(name, baseSalary);
            case Tester -> new Employee.Tester(name, baseSalary);
        };
        employeeList.add(employee); // Добавляем сотрудника в список
    }

    /**
     * Возвращает сумму зарплат всех сотрудников за указанный месяц
     * @param month номер месяца
     * @return сумма зарплат всех сотрудников за указанный месяц
     */
    public int getMonthSalary(int month) {
        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getMonthSalary(month);
        }
        return sum; // Возвращаем итоговую сумму
    }


    public String getName() {
        return name;
    }
}
