package com.javakc.copyright;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages= {"com.javakc"})
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class,args);
    }
}
