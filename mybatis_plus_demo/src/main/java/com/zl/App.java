package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Package: com.zl
 * @ClassName: App
 * @Author: luzhiwei
 * @Description: TODO
 * @Date: 2019/6/26 11:42
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.zl.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
