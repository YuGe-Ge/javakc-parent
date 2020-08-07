package com.javakc.cms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages= {"com.javakc"})
public class ApplicationCms {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationCms.class,args);
    }


}
