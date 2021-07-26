package com.elastic.group.manualsearch.config;

import com.elastic.group.manualsearch.model.Employee;
import com.elastic.group.manualsearch.repository.EmployeeRepository;
import com.elastic.group.manualsearch.utils.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@Slf4j
public class ElasticsearchClientConfig  extends AbstractElasticsearchConfiguration {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration
                                                        .builder()
                                                        .connectedTo("localhost:9200")
                                                        .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @PostConstruct
    @Scheduled(cron = "0 0/5 * * * ?")
    public void buildIndex() {
        elasticsearchOperations.indexOps(Employee.class).refresh();
        log.info("insert data to elastic search");
        employeeRepository.saveAll(CSVReader.processEmployeeFile("D:\\workspace\\search\\src\\main\\resources\\MOCK_DATA.csv"));
        log.info("data insertion successfull");
        AtomicInteger count = new AtomicInteger();
        employeeRepository.findAll().forEach(employee -> {
            log.info(employee.getFirstName());
            count.getAndIncrement();
        });
        log.info("count of employee  :  " + count);

    }
}
