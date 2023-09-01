package com.testsite.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TestBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBoardApplication.class, args);
    }

}
