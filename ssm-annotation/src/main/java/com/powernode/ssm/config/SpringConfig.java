package com.powernode.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/30 21:42
 * @description:
 */
@Configuration
@ComponentScan({"com.powernode.ssm.service"})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@Import({DataSourceConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
