package com.yanqi.petmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yanqi.petmanager.dao")
public class PetManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetManagerApplication.class, args);
    }

}
