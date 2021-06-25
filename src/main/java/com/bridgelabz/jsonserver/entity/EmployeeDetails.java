package com.bridgelabz.jsonserver.entity;

import java.time.LocalDate;

public class EmployeeDetails {
    public int id;
    public String name;
    String gender;
    public double salary;
    LocalDate startDate;

    public EmployeeDetails(int id, String name, String gender, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
    }
}
