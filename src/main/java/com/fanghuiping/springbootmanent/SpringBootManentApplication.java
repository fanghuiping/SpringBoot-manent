package com.fanghuiping.springbootmanent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootManentApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootManentApplication.class).properties(
                "spring.config.location=classpath:/config/application.yml"
        ).run(args);
    }

}
