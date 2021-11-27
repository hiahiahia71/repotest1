package com.qzsy.test.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = {"com.qzsy.test.*.dao"})
public class MybatisPlusConfig {
}
