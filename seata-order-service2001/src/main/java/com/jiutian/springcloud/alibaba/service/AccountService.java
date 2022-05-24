package com.jiutian.springcloud.alibaba.service;

import com.jiutian.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult<String> decrease(@RequestParam("userId") Long userId,
                                  @RequestParam("money") BigDecimal money);
}

