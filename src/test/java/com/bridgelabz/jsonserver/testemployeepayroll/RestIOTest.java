package com.bridgelabz.jsonserver.testemployeepayroll;

import com.bridgelabz.jsonserver.entity.EmployeeDetails;
import com.bridgelabz.jsonserver.service.EmployeePayroll;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class RestIOTest {
    @Before
    public void setup(){
        RestAssured.baseURI= "http://localhost";
        RestAssured.port= 3000;
    }
    private EmployeeDetails[] getEmployeeList() {
        Response response = RestAssured.get("/employee_payroll");
        System.out.println(response.toString());
        return new Gson().fromJson(response.asString(), EmployeeDetails[].class);
    }
    private Response addEmployeeToJsonServer(EmployeeDetails employeeDetails1) {
        String empJson = new Gson().toJson(employeeDetails1);
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(empJson);
        return request.post("/employee_payroll");
    }
    @Test
    public void givenEmployeeDataInJsonServer_WhenRetrieved_ShouldMatchTheCount() {
       EmployeeDetails[] employeeDetails = getEmployeeList();
       EmployeePayroll employeePayroll = new EmployeePayroll(Arrays.asList(employeeDetails));
       long entries = employeePayroll.countEntries();
        Assert.assertEquals(2, entries);
    }
    @Test
    public void givenNewEmployee_WhenAdded_ShouldMatch201ResponseAndCount() {
        EmployeeDetails[] employeeDetails = getEmployeeList();
        EmployeePayroll employeePayroll = new EmployeePayroll(Arrays.asList(employeeDetails));
        EmployeeDetails employeeDetails1 = new EmployeeDetails(3,"Mark Zuckerberg","M",3000.00, LocalDate.now());
        Response response = addEmployeeToJsonServer(employeeDetails1);
        int statusCode = response.statusCode();
        Assert.assertEquals(201,statusCode);

        employeeDetails = new Gson().fromJson(response.asString(),EmployeeDetails[].class);
        employeePayroll.addEmployee(employeeDetails1);
        long entries = employeePayroll.countEntries();
        Assert.assertEquals(3, entries);
    }

}
