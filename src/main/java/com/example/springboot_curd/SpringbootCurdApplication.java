package com.example.springboot_curd;

import com.example.springboot_curd.aspect.LogRecordAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.example.springboot_curd.*.mapper")
@EnableAspectJAutoProxy
@Import(LogRecordAspect.class)
public class SpringbootCurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCurdApplication.class, args);
    }

}
