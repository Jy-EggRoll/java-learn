package Homework.PTA5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 定义抽象类 Employee
abstract class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    // 构造方法
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // 抽象方法，用于计算月工资
    public abstract double earning();

    // 获取 firstName
    public String getFirstName() {
        return firstName;
    }

    // 设置 firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // 获取 lastName
    public String getLastName() {
        return lastName;
    }

    // 设置 lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // 获取 socialSecurityNumber
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return String.format("firstName:%s; lastName:%s; socialSecurityNumber:%s; earning:%.2f",
                firstName, lastName, socialSecurityNumber, earning());
    }

    // 实现 Comparable 接口的 compareTo 方法
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.earning(), other.earning());
    }
}

// 定义 SalaridEmployee 类，继承自 Employee
class SalaridEmployee extends Employee {
    private double weeklySalary;

    // 构造方法
    public SalaridEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    // 计算月工资
    @Override
    public double earning() {
        return weeklySalary * 4;
    }

    // 获取周薪
    public double getWeeklySalary() {
        return weeklySalary;
    }

    // 设置周薪
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

// 定义 HourlyEmployee 类，继承自 Employee
class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    // 构造方法
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hours = hours;
    }

    // 计算月工资
    @Override
    public double earning() {
        return wage * hours;
    }

    // 获取每小时工钱
    public double getWage() {
        return wage;
    }

    // 设置每小时工钱
    public void setWage(double wage) {
        this.wage = wage;
    }

    // 获取月工作小时数
    public double getHours() {
        return hours;
    }

    // 设置月工作小时数
    public void setHours(double hours) {
        this.hours = hours;
    }
}

// 定义 CommisionEmployee 类，继承自 Employee
class CommisionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    // 构造方法
    public CommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // 计算月工资
    @Override
    public double earning() {
        return grossSales * commissionRate;
    }

    // 获取销售额
    public double getGrossSales() {
        return grossSales;
    }

    // 设置销售额
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    // 获取提成比率
    public double getCommissionRate() {
        return commissionRate;
    }

    // 设置提成比率
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}

// 定义 basePlusCommisionEmployee 类，继承自 CommisionEmployee
class basePlusCommisionEmployee extends CommisionEmployee {
    private double baseSalary;

    // 构造方法
    public basePlusCommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    // 计算月工资
    @Override
    public double earning() {
        return super.earning() + baseSalary;
    }

    // 获取月基本工资
    public double getBaseSalary() {
        return baseSalary;
    }

    // 设置月基本工资
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

// 定义 Main 类
public class MyEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        // 读取雇员信息
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            String socialSecurityNumber = scanner.next();

            switch (type) {
                case 0:
                    double weeklySalary = scanner.nextDouble();
                    employees[i] = new SalaridEmployee(firstName, lastName, socialSecurityNumber, weeklySalary);
                    break;
                case 1:
                    double wage = scanner.nextDouble();
                    double hours = scanner.nextDouble();
                    employees[i] = new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours);
                    break;
                case 2:
                    double grossSales = scanner.nextDouble();
                    double commissionRate = scanner.nextDouble();
                    employees[i] = new CommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
                            commissionRate);
                    break;
                case 3:
                    grossSales = scanner.nextDouble();
                    commissionRate = scanner.nextDouble();
                    double baseSalary = scanner.nextDouble();
                    employees[i] = new basePlusCommisionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
                            commissionRate, baseSalary);
                    break;
            }
        }

        int m = scanner.nextInt();
        // 处理查询请求
        for (int i = 0; i < m; i++) {
            int queryType = scanner.nextInt();
            String queryValue = scanner.next();
            List<Employee> result = new ArrayList<>();

            for (Employee employee : employees) {
                if ((queryType == 0 && employee.getFirstName().equals(queryValue)) ||
                        (queryType == 1 && employee.getSocialSecurityNumber().equals(queryValue))) {
                    result.add(employee);
                }
            }

            Employee[] resultArray = result.toArray(new Employee[0]);
            Arrays.sort(resultArray);

            for (Employee employee : resultArray) {
                System.out.println(employee);
            }
        }

        scanner.close();
    }
}