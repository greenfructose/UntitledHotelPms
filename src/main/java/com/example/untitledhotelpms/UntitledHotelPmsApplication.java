package com.example.untitledhotelpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UntitledHotelPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UntitledHotelPmsApplication.class, args);
    }

}
