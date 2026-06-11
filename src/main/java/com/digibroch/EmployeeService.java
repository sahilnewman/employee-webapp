package com.digibroch;

public class EmployeeService {

    public String getEmployeeDepartment(String department) {

        if(department == null || department.isEmpty()) {
            return "Unknown";
        }

        return department;
    }

    public int calculateBonus(int salary) {
        return salary * 10 / 100;
    }
}