package com.demo.springbatch.controller;

import com.demo.springbatch.employeeservice.EmployeeService;
import com.demo.springbatch.entity.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;


    @PostMapping("/importemp")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.OK);
    }

    @GetMapping("/export")
    public void export() {
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
