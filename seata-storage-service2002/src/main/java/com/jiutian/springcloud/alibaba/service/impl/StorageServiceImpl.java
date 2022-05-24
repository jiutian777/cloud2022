package com.jiutian.springcloud.alibaba.service.impl;

import com.jiutian.springcloud.alibaba.dao.StorageDao;
import com.jiutian.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2022/5/23 21:24
 * @Author: jiutian
 * @Description:
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service 中扣减库存开始");
        storageDao.decrease(productId, count);
        LOGGER.info("------->storage-service 中扣减库存结束");
    }
}
