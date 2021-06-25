package com.bridgelabz.jsonserver.service;

import com.bridgelabz.jsonserver.entity.EmployeeDetails;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayroll {
    List<EmployeeDetails> employeeDetailsList;

    public EmployeePayroll(List<EmployeeDetails> employeeDetailsList) {
        this.employeeDetailsList = new ArrayList<>(employeeDetailsList);
    }
    public long countEntries() {
        return this.employeeDetailsList.size();
    }
    public void addEmployee(EmployeeDetails employeeDetails){
        this.employeeDetailsList.add(employeeDetails);
    }
    public void updateEmployee(String name, int salary) {
        EmployeeDetails employeeDetails = this.getEmployee(name);
        if(employeeDetails != null)
            employeeDetails.salary = salary;
    }
    public EmployeeDetails getEmployee(String name) {
        return this.employeeDetailsList.stream()
                .filter(employeeDetails -> employeeDetails.name.equals(name))
                .findFirst()
                .orElse(null);
    }
    public void deleteEmployee(String name){
        this.employeeDetailsList.remove(this.getEmployee(name));
    }
}
