package com.elastic.group.manualsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employee")
public class Employee {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String description;

}
