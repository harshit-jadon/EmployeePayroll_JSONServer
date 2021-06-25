package com.bridgelabz.jsonserver.entity;

public class EmployeeDetails {
    public int id;
    public String name;
    public double salary;
    String gender;

    public EmployeeDetails(int id, String name, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }
}
