package com.jiutian.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
public interface StorageService {

   void decrease(@RequestParam("productId") Long productId,
                 @RequestParam("count") Integer count);
}
