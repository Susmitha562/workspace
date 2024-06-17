package com.demo.springbatch.employeeservice;

import com.demo.springbatch.entity.Employee;
import com.demo.springbatch.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }
}
