package com.sanli.pay.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.sanli.pay.mapper"})
public class MybatisConfig {
}
