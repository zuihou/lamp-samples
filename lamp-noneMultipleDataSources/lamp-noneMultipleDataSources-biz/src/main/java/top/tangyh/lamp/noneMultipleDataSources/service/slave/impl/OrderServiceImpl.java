package top.tangyh.lamp.noneMultipleDataSources.service.slave.impl;

import top.tangyh.basic.base.service.SuperServiceImpl;
import top.tangyh.lamp.noneMultipleDataSources.dao.slave.OrderMapper;
import top.tangyh.lamp.noneMultipleDataSources.entity.slave.Order;
import top.tangyh.lamp.noneMultipleDataSources.service.slave.OrderService;
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

    @Transactional(rollbackFor = Exception.class, transactionManager = "slaveTransactionManager")
    public boolean saveBatch(Collection<Order> entityList) {
        super.saveBatch(entityList);
        int a = 1/0;
        return true;
    }
}
