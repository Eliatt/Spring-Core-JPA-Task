package com.eli.springexam_26_10_2020.clrTests;

import com.eli.springexam_26_10_2020.beans.Employee;
import com.eli.springexam_26_10_2020.beans.Job;
import com.eli.springexam_26_10_2020.service.CompanyService;
import com.eli.springexam_26_10_2020.utils.HeadersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CompanyServiceTests implements CommandLineRunner {
    @Autowired
    CompanyService companyService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(HeadersUtil.COMPANY_SERVICE_TEST);

        Job j1 = new Job();
        j1.setDescription("Cleaning the back yard");
        j1.setEndDate(Date.valueOf("2020-10-30"));

        Job j2 = new Job();
        j2.setDescription("Fixing the Fence");
        j2.setEndDate(Date.valueOf("2020-10-30"));

        Job j3 = new Job();
        j3.setDescription("Painting the rear wall");
        j3.setEndDate(Date.valueOf("2020-12-30"));

        Job j4 = new Job();
        j4.setDescription("Buying Spray paint");
        j4.setEndDate(Date.valueOf("2020-11-10"));

        Job j5 = new Job();
        j5.setDescription("Adjusting front gate level");
        j5.setEndDate(Date.valueOf("2021-01-05"));


        System.out.println(" *** Add Employee *** ");
        Employee e1 = new Employee();
        e1.setName("Dani De Vito");
        e1.setSalary(8000);
        try {
            e1.addJob(j3);
            e1.addJob(j1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Employee e2 = new Employee();
        e2.setName("Hanna Banana");
        e2.setSalary(8900);
        try {
            e2.addJob(j4);
            e2.addJob(j2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Employee e3 = new Employee();
        e3.setName("Yossef Yossef");
        e3.setSalary(6700);
        try {
            e3.addJob(j5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        companyService.addEmployee(e1);
        companyService.addEmployee(e2);
        companyService.addEmployee(e3);
        System.out.println("All listed Employees: " + companyService.getAllEmployees());


        System.out.println(" *** Get By Id *** ");
        System.out.println("Employee by ID #2:" + companyService.getById(2L));


        System.out.println(" *** Get By Name *** ");
        System.out.println(companyService.getByName("Dani De Vito"));


        System.out.println(" *** Get All Employees *** ");
        System.out.println("All Listed Employees: " + companyService.getAllEmployees());


        System.out.println(" *** Get All Jobs *** ");
        System.out.println("All Listed Jobs: " + companyService.getAllJobs());


        System.out.println(" *** Get Jobs By End Date *** ");
        System.out.println(companyService.getByEndDate(Date.valueOf("2020-10-30")));


        System.out.println(" *** Get Jobs By Date Range *** ");
        System.out.println(companyService.getByDateRange(Date.valueOf("2020-11-10"), Date.valueOf("2021-12-30")));


    }
}
