package top.tangyh.lamp.noneMultipleDataSources.controller.slave;

import top.tangyh.lamp.noneMultipleDataSources.dto.master.ProductSaveDTO;
import top.tangyh.lamp.noneMultipleDataSources.entity.slave.Order;
import top.tangyh.lamp.noneMultipleDataSources.dto.slave.OrderSaveDTO;
import top.tangyh.lamp.noneMultipleDataSources.dto.slave.OrderUpdateDTO;
import top.tangyh.lamp.noneMultipleDataSources.dto.slave.OrderPageQuery;
import top.tangyh.lamp.noneMultipleDataSources.service.slave.OrderService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import top.tangyh.basic.base.controller.SuperController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.tangyh.basic.echo.core.EchoService;
import top.tangyh.basic.base.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.tangyh.basic.annotation.security.PreAuth;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 前端控制器
 * 订单
 * </p>
 *
 * @author zuihou
 * @date 2021-05-18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/order")
@Api(value = "Order", tags = "订单")
@PreAuth(replace = "noneMultipleDataSources:order:", enabled = false)
public class OrderController extends SuperController<OrderService, Long, Order, OrderPageQuery, OrderSaveDTO, OrderUpdateDTO> {

    @Autowired
    private EchoService echoService;

    @Override
    public void handlerResult(IPage<Order> page) {
        // 想让返回值实现自动回显，请将此行代码打开
         echoService.action(page);
    }

    @PostMapping("/saveBatch")
    public R<List<Order>> saveBatch(@RequestBody List<Order> saveDTO) {
        this.getBaseService().saveBatch(saveDTO);
        return R.success(saveDTO);
    }

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<Order> orderList = list.stream().map((map) -> {
            Order order = Order.builder().build();
            //TODO 请在这里完成转换
            return order;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(orderList));
    }
}
