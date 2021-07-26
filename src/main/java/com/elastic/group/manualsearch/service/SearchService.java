package com.elastic.group.manualsearch.service;

import com.elastic.group.manualsearch.model.Employee;

import java.util.List;

public interface SearchService {

    List<Employee> findByFirstName(final String searchString);

    List<Employee> findEmployeeList();
}
