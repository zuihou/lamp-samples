package com.tangyh.lamp.seata.feign;

import com.tangyh.basic.base.R;
import com.tangyh.lamp.seata.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * This is a Description
 *
 * @author zuihou
 * @date 2019/08/12
 */
@FeignClient(name = "lamp-seata-at-consumer-server", path = "/seata")
public interface ProductApi {
    /**
     * 新增时发生异常
     *
     * @param data
     * @return
     */
    @PostMapping("/saveEx")
    R<Product> saveEx(@RequestBody Product data);

    /**
     * 新增
     *
     * @param data
     * @return
     */
    @PostMapping("/save")
    R<Product> save(@RequestBody Product data);
}
