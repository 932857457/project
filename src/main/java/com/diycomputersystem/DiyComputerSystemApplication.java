package com.diycomputersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.diycomputersystem.mapper")
public class DiyComputerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiyComputerSystemApplication.class, args);
    }

}
