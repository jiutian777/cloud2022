package com.jiutian.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@Mapper
public interface AccountDao {

    //扣减库存
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
