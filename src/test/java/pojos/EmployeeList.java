// EmployeeList.java (POJO class to represent the list of employees)
package pojos;

import java.util.List;

public class EmployeeList {
    private List<Employee> data;

    // Getter and setter for data
    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
