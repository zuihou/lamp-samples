package top.tangyh.lamp.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.basic.base.service.SuperCacheService;
import top.tangyh.lamp.example.dto.MatterInOutSumFormBean;
import top.tangyh.lamp.example.entity.Order;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 订单
 * </p>
 *
 * @author zuihou
 * @date 2019-08-13
 */
public interface OrderService extends SuperCacheService<Order> {

    List<Order> find(Order data);

    List<Order> findInjectionResult(Order data);

    IPage<Order> findPage(IPage page, Wrapper<Order> wrapper);

    boolean save1(Order order);

    boolean save2(Order order);

    IPage<Order> customPage(PageParams<MatterInOutSumFormBean> data);
}
