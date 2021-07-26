package com.elastic.group.manualsearch.resource;


import com.elastic.group.manualsearch.model.Employee;
import com.elastic.group.manualsearch.service.SearchService;
import com.elastic.group.manualsearch.utils.SearchQueryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/")
public class SearchController {

    private SearchService searchService;

    private SearchQueryBuilder searchQueryBuilder;

    @Autowired
    public SearchController(SearchService searchService, SearchQueryBuilder searchQueryBuilder) {
        this.searchService = searchService;
        this.searchQueryBuilder = searchQueryBuilder;
    }

    @GetMapping(value = "search/{value}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String value){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(searchService.findByFirstName(value));
    }

    @GetMapping(value = "search/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(searchService.findEmployeeList());
    }

    @GetMapping(value = "search/all/{text}")
    public ResponseEntity<List<Employee>> getAllEmployeeWithsearchString(@PathVariable String text){
        List<Employee> employees = searchQueryBuilder.getAll(text);
        log.info("Employee Size : " + employees.size());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employees);
    }

}
