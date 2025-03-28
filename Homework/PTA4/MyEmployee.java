package Homework.PTA4;
import java.util.Scanner;

abstract class Employee {
    public abstract int getSalary();
}

class Manager extends Employee {
    private int monthlySalary;

    public Manager(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int getSalary() {
        return monthlySalary;
    }
}

class Salesman extends Employee {
    private int baseSalary;
    private int commission;

    public Salesman(int baseSalary, int commission) {
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    @Override
    public int getSalary() {
        return baseSalary + commission;
    }
}

class Worker extends Employee {
    private int workingDays;
    private int dailyWage;

    public Worker(int workingDays, int dailyWage) {
        this.workingDays = workingDays;
        this.dailyWage = dailyWage;
    }

    @Override
    public int getSalary() {
        return workingDays * dailyWage;
    }
}

public class MyEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int managerSalary = scanner.nextInt();
        int baseSalary = scanner.nextInt();
        int commission = scanner.nextInt();
        int workingDays = scanner.nextInt();
        int dailyWage = scanner.nextInt();

        Employee manager = new Manager(managerSalary);
        Employee salesman = new Salesman(baseSalary, commission);
        Employee worker = new Worker(workingDays, dailyWage);

        System.out.println(manager.getSalary());
        System.out.println(salesman.getSalary());
        System.out.println(worker.getSalary());

        scanner.close();
    }
}
