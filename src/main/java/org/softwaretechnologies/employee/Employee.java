package org.softwaretechnologies.employee;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Создайте классы, наследуемые от Employee и представляющие каждый из типов указанный в enum EmployeeType.
 * Для каждого из них реализуйте функцию getMonthSalary по следующим формулам:
 * Tester: baseSalary * количество дней в месяце в текущем году. Вычисление количества дней в месяце: YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth()
 * Manager: если месяц четный, то baseSalary, иначе baseSalary/2
 * Programmer: всегда baseSalary
 */
public abstract class Employee {
    protected String name;
    protected int baseSalary;

    protected Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract int getMonthSalary(int month);

    public String getName() {
        return name;
    }



    public class Manager extends Employee{
        public Manager(String name, int baseSalary) {
            super(name, baseSalary);
        }
        @Override
        public int getMonthSalary(int month) {
            if (month % 2 == 0){return baseSalary;}
            else{return baseSalary/2;}
        }

    }

    public class Programmer extends Employee{
        public Programmer(String name, int baseSalary) {
            super(name, baseSalary);
        }
        @Override
        public int getMonthSalary(int month) {
            return baseSalary;
        }
    }

    public class Tester extends Employee{
        protected Tester(String name, int baseSalary) {
            super(name, baseSalary);
        }
        @Override
        public int getMonthSalary(int month) {
            return baseSalary * YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth();
        }
    }

}
