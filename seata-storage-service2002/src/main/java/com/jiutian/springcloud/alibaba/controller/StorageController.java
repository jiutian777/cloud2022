package com.jiutian.springcloud.alibaba.controller;

import com.jiutian.springcloud.alibaba.domain.CommonResult;
import com.jiutian.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date: 2022/5/15 17:14
 * @Author: jiutian
 * @Description:
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult<String> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200,"扣减库存成功！");
    }
}
