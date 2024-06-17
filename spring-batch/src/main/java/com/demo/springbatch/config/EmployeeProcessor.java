package com.demo.springbatch.config;

import com.demo.springbatch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeProcessor implements ItemProcessor<Employee,Employee> {
    @Override
    public Employee process(Employee employee) throws Exception {
        return employee;
    }
}
