package com.jiutian.springcloud.alibaba.dao;

import com.jiutian.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@Mapper
public interface OrderDao {

    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从 0 改为 1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
