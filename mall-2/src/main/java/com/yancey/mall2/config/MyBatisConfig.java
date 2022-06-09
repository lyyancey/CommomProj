package com.yancey.mall2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisConfig
 * @Description TODO
 * @Author Yancey
 * @Date 2022/6/3 13:50
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@MapperScan("com.yancey.mall2.mbg.mapper")
public class MyBatisConfig {
}
