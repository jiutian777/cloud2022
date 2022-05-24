package com.jiutian.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
public interface AccountService {

   void decrease(@RequestParam("productId") Long userId,
                 @RequestParam("money") BigDecimal money);
}
