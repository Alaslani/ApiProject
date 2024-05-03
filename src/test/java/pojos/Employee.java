package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String employee_name;
    private int employee_age;
    private int employee_salary;

    // Getters and setters

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_age=" + employee_age +
                ", employee_salary=" + employee_salary +
                '}';
    }
}