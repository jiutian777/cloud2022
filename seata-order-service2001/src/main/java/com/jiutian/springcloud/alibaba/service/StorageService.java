package com.jiutian.springcloud.alibaba.service;

import com.jiutian.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult<String> decrease(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count);
}
