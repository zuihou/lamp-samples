package com.tangyh.lamp.noneMultipleDataSources.config;

import com.tangyh.lamp.oauth.api.LogApi;
import com.tangyh.basic.boot.config.BaseConfig;
import com.tangyh.basic.log.event.SysLogListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * None模式多数据源示例-Web配置
 *
 * @author zuihou
 * @date 2021-05-18
 */
@Configuration
public class NoneMultipleDataSourcesWebConfiguration extends BaseConfig {

    /**
     * lamp.log.enabled = true 并且 lamp.log.type=DB时实例该类
     */
    @Bean
    @ConditionalOnExpression("${lamp.log.enabled:true} && 'DB'.equals('${lamp.log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogApi logApi) {
        return new SysLogListener(logApi::save);
    }
}
