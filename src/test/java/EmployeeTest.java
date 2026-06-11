package com.digibroch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    EmployeeService service = new EmployeeService();

    @Test
    public void testDepartment() {

        String result =
                service.getEmployeeDepartment("DevOps");

        assertEquals("DevOps", result);
    }

    @Test
    public void testDepartmentNull() {

        String result =
                service.getEmployeeDepartment("");

        assertEquals("Unknown", result);
    }

    @Test
    public void testBonusCalculation() {

        int bonus =
                service.calculateBonus(100000);

        assertEquals(10000, bonus);
    }
}