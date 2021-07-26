package top.tangyh.lamp.seata.service.impl;

import top.tangyh.basic.base.service.SuperServiceImpl;
import top.tangyh.lamp.seata.dao.ProductMapper;
import top.tangyh.lamp.seata.entity.Product;
import top.tangyh.lamp.seata.service.ProductService;
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
}
