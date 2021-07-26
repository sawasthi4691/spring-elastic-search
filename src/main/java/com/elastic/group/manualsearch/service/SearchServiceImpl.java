package com.elastic.group.manualsearch.service;

import com.elastic.group.manualsearch.model.Employee;
import com.elastic.group.manualsearch.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public SearchServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findByFirstName(String searchString) {
        log.info("findByFirstName : starts");
        return employeeRepository.findByFirstName(searchString);
    }

    @Override
    public List<Employee> findEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employees.add(employee);
        }
        return employees;
    }

}