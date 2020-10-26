package com.eli.springexam_26_10_2020.beans;


import com.eli.springexam_26_10_2020.exceptions.FailOperationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) throws FailOperationException {
        for (Job job1 : jobs) {
            if (job.getDescription().equals(job1.getDescription())) {
                throw new FailOperationException(
                        "Job matching this description: "
                                + job1.getDescription() + "Already registerd, and cannot be added to job list.");
            }
        }
            jobs.add(job);
        }
    }
