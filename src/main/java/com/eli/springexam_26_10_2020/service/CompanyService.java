package com.eli.springexam_26_10_2020.service;

import com.eli.springexam_26_10_2020.beans.Employee;
import com.eli.springexam_26_10_2020.beans.Job;
import com.eli.springexam_26_10_2020.repository.EmployeeRepository;
import com.eli.springexam_26_10_2020.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.getOne(id);
    }

    public Employee getByName(String name) {
        return employeeRepository.getByName(name);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getByEndDate(Date endDate) {
        return jobRepository.getByEndDate(endDate);
    }

    public List<Job> getByDateRange(Date d1, Date d2) {
        return jobRepository.getByEndDateBetween(d1, d2);
    }


}

