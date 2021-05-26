package com.tangyh.lamp.demo.controller.test;

import com.tangyh.basic.base.R;
import com.tangyh.lamp.demo.entity.Product;
import com.tangyh.lamp.demo.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式事务测试类
 *
 * @author zuihou
 * @date 2019/08/12
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/seata")
@Api(value = "SeataTxController", tags = "分布式事务测试类")
@RequiredArgsConstructor
public class SeataTxController {

    private final ProductService productService;


    @PostMapping("/save")
    public R<Product> save(@RequestBody Product data) {
        log.info("data={}", data);
        productService.save(data);
        return R.success(data);
    }

    @GetMapping("/get/{key}")
    public R<String> get(@PathVariable("key") String key) {
        log.info("data={}", key);
        return R.success(key);
    }

    @PostMapping("/saveEx")
    public R<Product> saveEx(@RequestBody Product data) {
        log.info("data={}", data);
        productService.saveEx(data);
        return R.success(data);
    }
}
