package com.elastic.group.manualsearch.repository;

import com.elastic.group.manualsearch.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee,Long> {

    List<Employee> findByFirstName(String value);

    List<Employee> findByLastName(String value);

    List<Employee> findByDescription(String value);
}
