package top.tangyh.lamp.example.controller;


import top.tangyh.basic.annotation.security.PreAuth;
import top.tangyh.basic.base.controller.SuperCacheController;
import top.tangyh.lamp.example.dto.OrderPageDTO;
import top.tangyh.lamp.example.dto.OrderSaveDTO;
import top.tangyh.lamp.example.dto.OrderUpdateDTO;
import top.tangyh.lamp.example.entity.Order;
import top.tangyh.lamp.example.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * 订单
 * </p>
 *
 * @author zuihou
 * @date 2019-08-13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/order")
@Api(value = "Order", tags = "订单")
@PreAuth(replace = "order:", enabled = false)
public class OrderController extends SuperCacheController<OrderService, Long, Order, OrderPageDTO, OrderSaveDTO, OrderUpdateDTO> {

}
