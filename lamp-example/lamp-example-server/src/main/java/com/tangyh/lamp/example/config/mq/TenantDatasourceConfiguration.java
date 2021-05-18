package com.tangyh.lamp.example.config.mq;

import com.alibaba.fastjson.JSONObject;
import com.tangyh.basic.database.properties.DatabaseProperties;
import com.tangyh.basic.mq.properties.MqProperties;
import com.tangyh.lamp.common.constant.BizMqQueue;
import com.tangyh.lamp.tenant.dto.DataSourcePropertyDTO;
import com.tangyh.lamp.tenant.service.DataSourceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;

import static com.tangyh.lamp.common.constant.BizConstant.INIT_DS_PARAM_METHOD;
import static com.tangyh.lamp.common.constant.BizConstant.INIT_DS_PARAM_METHOD_INIT;
import static com.tangyh.lamp.common.constant.BizConstant.INIT_DS_PARAM_TENANT;


/**
 * 消息队列开启时，启用
 *
 * @author zuihou
 * @date 2020年04月05日19:22:02
 */
@Slf4j
@AllArgsConstructor
@Configuration
@ConditionalOnProperty(prefix = MqProperties.PREFIX, name = "enabled", havingValue = "true")
public class TenantDatasourceConfiguration {

    private final DataSourceService dataSourceService;

    @Bean
    @ConditionalOnProperty(prefix = DatabaseProperties.PREFIX, name = "multiTenantType", havingValue = "DATASOURCE")
    public Queue dsQueue() {
        return new Queue(BizMqQueue.TENANT_DS_QUEUE_BY_ORDER);
    }

    @Bean
    @ConditionalOnProperty(prefix = DatabaseProperties.PREFIX, name = "multiTenantType", havingValue = "DATASOURCE")
    public Binding dsQueueBinding() {
        return new Binding(BizMqQueue.TENANT_DS_QUEUE_BY_ORDER, Binding.DestinationType.QUEUE, BizMqQueue.TENANT_DS_FANOUT_EXCHANGE_ORDER, "", new HashMap(1));
    }

    @RabbitListener(queues = BizMqQueue.TENANT_DS_QUEUE_BY_ORDER)
    @ConditionalOnProperty(prefix = DatabaseProperties.PREFIX, name = "multiTenantType", havingValue = "DATASOURCE")
    public void dsRabbitListener(@Payload String param) {
        log.debug("异步初始化数据源=={}", param);
        JSONObject map = JSONObject.parseObject(param);
        if (INIT_DS_PARAM_METHOD_INIT.equals(map.getString(INIT_DS_PARAM_METHOD))) {
            dataSourceService.initConnect(map.getObject(INIT_DS_PARAM_TENANT, DataSourcePropertyDTO.class));
        } else {
            dataSourceService.remove(map.getString(INIT_DS_PARAM_TENANT));
        }
    }
}
