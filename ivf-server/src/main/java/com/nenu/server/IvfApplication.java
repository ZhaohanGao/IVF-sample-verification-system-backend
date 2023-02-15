package com.nenu.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Breon
 * @description: TODO
 * @date: 2022/10/15 10:40
 */
@SpringBootApplication
@MapperScan("com.nenu.server.mapper")
public class IvfApplication {
    public static void main(String[] args) {
        SpringApplication.run(IvfApplication.class,args);
    }
}
