package top.tangyh.lamp.example.controller;

import top.tangyh.basic.base.R;
import top.tangyh.lamp.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author tangyh
 * @version v1.0
 * @date 2021/5/26 6:13 下午
 * @create [2021/5/26 6:13 下午 ] [tangyh] [初始创建]
 */
@Component
public class TestUtil {

    @Autowired
    DemoTest123Api demoTestApi;
    public R<Product> test(Product data) {
        return demoTestApi.save(data);
    }
    public R<String> test2(String key) {
        return demoTestApi.get(key);
    }
    @FeignClient(name = "${lamp.feign.demo-server:lamp-demo-server}", path = "/seata", fallback = DemoTest123ApiImpl.class)
    interface DemoTest123Api {
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
        @GetMapping("/get/{key}")
        R<String> get(@PathVariable("key") String key);
    }
    @Component
    static class DemoTest123ApiImpl implements DemoTest123Api {
        @Override
        public R<Product> saveEx(Product data) {
            return R.timeout();
        }

        @Override
        public R<Product> save(Product data) {
            return R.timeout();
        }
        @Override
        public R<String> get(String key) {
            return R.timeout();
        }
    }
}
