package com.bridgelabz.jsonserver.testemployeepayroll;

import com.bridgelabz.jsonserver.entity.EmployeeDetails;
import com.bridgelabz.jsonserver.service.EmployeePayroll;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    @Test
    public void givenEmployeeDataInJsonServer_WhenRetrieved_ShouldMatchTheCount() {
       EmployeeDetails[] employeeDetails = getEmployeeList();
       EmployeePayroll employeePayroll = new EmployeePayroll(Arrays.asList(employeeDetails));
       long entries = employeePayroll.countEntries();
        Assert.assertEquals(2, entries);
    }

}
