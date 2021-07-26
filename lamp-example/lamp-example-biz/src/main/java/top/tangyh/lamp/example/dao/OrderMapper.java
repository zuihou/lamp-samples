package top.tangyh.lamp.example.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.basic.database.mybatis.auth.DataScope;
import top.tangyh.lamp.example.dto.MatterInOutSumFormBean;
import top.tangyh.lamp.example.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 订单
 * </p>
 *
 * @author zuihou
 * @date 2019-08-13
 */
@Repository
public interface OrderMapper extends SuperMapper<Order> {

    List<Order> find(@Param("data") Order data);


    IPage<Order> findPage(IPage page, @Param(Constants.WRAPPER) Wrapper<Order> wrapper, DataScope dataScope);

    IPage<Order> customPage(IPage<Order> page, @Param("m") MatterInOutSumFormBean model);
}
