package com.tangyh.lamp.seata.service.impl;

import com.tangyh.basic.base.service.SuperServiceImpl;
import com.tangyh.lamp.seata.dao.OrderMapper;
import com.tangyh.lamp.seata.entity.Order;
import com.tangyh.lamp.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * <p>
 * 业务实现类
 * 订单
 * </p>
 *
 * @author zuihou
 * @date 2021-05-18
 */
@Slf4j
@Service
public class OrderServiceImpl extends SuperServiceImpl<OrderMapper, Order> implements OrderService {
    @Override

    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<Order> entityList) {
        super.saveBatch(entityList);
        int a = 1/0;
        return true;
    }
}
