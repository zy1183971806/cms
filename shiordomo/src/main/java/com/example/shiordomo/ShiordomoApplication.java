package com.example.shiordomo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan(basePackages = {"com.example.shiordomo.*.mapper"})
@SpringBootApplication
public class ShiordomoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiordomoApplication.class, args);
    }

}
