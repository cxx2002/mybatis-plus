package com.cxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxx.mapper")
public class MybatisPlusMybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMybatisXApplication.class, args);
    }

}
