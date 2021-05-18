package com.tangyh.lamp.noneMultipleDataSources.service.master.impl;

import com.tangyh.lamp.noneMultipleDataSources.dao.master.ProductMapper;
import com.tangyh.lamp.noneMultipleDataSources.entity.master.Product;
import com.tangyh.lamp.noneMultipleDataSources.service.master.ProductService;
import com.tangyh.basic.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * <p>
 * 业务实现类
 * 商品
 * </p>
 *
 * @author zuihou
 * @date 2021-05-18
 */
@Slf4j
@Service
public class ProductServiceImpl extends SuperServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    @Transactional(rollbackFor = Exception.class, transactionManager = "masterTransactionManager")
    public boolean saveBatch(Collection<Product> entityList) {
        super.saveBatch(entityList);

        return true;
    }
}
