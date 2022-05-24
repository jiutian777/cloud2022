package com.jiutian.springcloud.alibaba.controller;

import com.jiutian.springcloud.alibaba.domain.CommonResult;
import com.jiutian.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户
     */
    @RequestMapping(value = "/account/decrease")
    public CommonResult<String> decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200,"扣减账户成功！");
    }
}
