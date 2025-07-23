package com.marg.margpoc;

import com.marg.margpoc.repository.OutstandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

public class MargPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MargPocApplication.class, args);
    }

}
