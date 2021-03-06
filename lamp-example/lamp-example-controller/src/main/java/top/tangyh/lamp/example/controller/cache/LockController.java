package top.tangyh.lamp.example.controller.cache;

import top.tangyh.basic.base.R;
import top.tangyh.basic.lock.DistributedLock;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zuihou
 * @date 2020/6/7 下午11:06
 */
@Slf4j
@RestController
@RequestMapping("/lock")
@Api(value = "lock", tags = "分布式锁演示")
@Setter
@RequiredArgsConstructor
public class LockController {
    public static int STOCK = 5;
    private final DistributedLock distributedLock;

    @GetMapping("/seckill")
    public R seckill(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "count", defaultValue = "20") Integer count) {
        STOCK = 5;
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(() ->
                    new LockController(distributedLock).test(key)
            );
            t.start();
        }


        return R.success("aaa");
    }

    @SneakyThrows
    private void test(String key) {
        boolean lock = distributedLock.lock(key);
        log.info("thread={}, lock={}", Thread.currentThread().getId(), lock);
        Thread.sleep(100);
        if (lock) {
            try {
                int s = STOCK--;
                Thread.sleep(100);
                if (s <= 0) {
                    STOCK = 0;
                    log.info("没库存了： thread={}", Thread.currentThread().getId());
                } else {
                    log.info("恭喜你： thread={}", Thread.currentThread().getId());
                }
            } finally {
                distributedLock.releaseLock(key);
            }
        } else {
            log.info("没库存了啦啦" + Thread.currentThread().getId());
        }
    }

    @SneakyThrows
    private void test2(String key) {
        boolean lock = true;
        log.info("thread={}, lock={}", Thread.currentThread().getId(), lock);
        Thread.sleep(100);
        if (lock) {
            try {
                int s = STOCK--;
                Thread.sleep(100);
                if (s <= 0) {
                    STOCK = 0;
                    log.info("没库存了： thread={}", Thread.currentThread().getId());
                } else {
                    log.info("恭喜你： thread={}", Thread.currentThread().getId());
                }
            } finally {
                distributedLock.releaseLock(key);
            }
        } else {
            log.info("没库存了啦啦" + Thread.currentThread().getId());
        }
    }

}
