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
}
