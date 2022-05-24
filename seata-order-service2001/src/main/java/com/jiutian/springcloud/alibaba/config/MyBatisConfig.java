package com.jiutian.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@Configuration
@MapperScan({"com.jiutian.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
