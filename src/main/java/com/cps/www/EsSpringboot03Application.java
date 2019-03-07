package com.cps.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@MapperScan("com.cps.www.dao")
@EnableElasticsearchRepositories("com.cps.www.es")
public class EsSpringboot03Application {

    public static void main(String[] args) {

        SpringApplication.run(EsSpringboot03Application.class, args);
    }

}
