package com.tangyh.lamp.seata.service;

import com.tangyh.basic.base.service.SuperService;
import com.tangyh.lamp.seata.entity.Product;

/**
 * <p>
 * 业务接口
 * 商品
 * </p>
 *
 * @author zuihou
 * @date 2021-05-18
 */
public interface ProductService extends SuperService<Product> {

    boolean saveEx(Product data);
}
