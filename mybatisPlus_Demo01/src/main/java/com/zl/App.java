package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: App
 * @Description: TODO
 * @Author: zl
 * @Date: 2019/10/15 22:29
 * @Version: 1.0
 **/
@SpringBootApplication
@MapperScan("com.zl.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
