package com.tangyh.lamp.seata.service.impl;

import com.tangyh.basic.base.service.SuperServiceImpl;
import com.tangyh.lamp.seata.dao.ProductMapper;
import com.tangyh.lamp.seata.entity.Product;
import com.tangyh.lamp.seata.service.ProductService;
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
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<Product> entityList) {
        super.saveBatch(entityList);

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Product entity) {
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveEx(Product data) {
        boolean bool = super.save(data);
        int a = 1 / 0;
        log.info("a=", a);
        return bool;
    }
}
