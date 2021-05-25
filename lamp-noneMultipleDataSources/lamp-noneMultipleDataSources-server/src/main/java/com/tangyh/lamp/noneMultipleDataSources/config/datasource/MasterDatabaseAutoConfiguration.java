package com.tangyh.lamp.noneMultipleDataSources.config.datasource;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.p6spy.engine.spy.P6DataSource;
import com.tangyh.basic.database.datasource.BaseDatabaseConfiguration;
import com.tangyh.basic.database.properties.DatabaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * lamp.database.multiTenantType != DATASOURCE 时，该类启用.
 * 此时，项目的多租户模式切换成：${lamp.database.multiTenantType}。
 * <p>
 * NONE("非租户模式"): 不存在租户的概念
 * COLUMN("字段模式"): 在sql中拼接 tenant_code 字段
 * SCHEMA("独立schema模式"): 在sql中拼接 数据库 schema
 * <p>
 * COLUMN和SCHEMA模式的实现 参考下面的 @see 中的2个类
 *
 * @author zuihou
 * @date 2021-05-18
 * 断点查看原理：👇👇👇
 * @see com.tangyh.basic.database.datasource.BaseMybatisConfiguration#mybatisPlusInterceptor()
 * @see com.tangyh.basic.boot.interceptor.HeaderThreadLocalInterceptor
 */
@Configuration
@Slf4j
@MapperScan(
        basePackages = {"com.tangyh.lamp.noneMultipleDataSources.dao.master"}, annotationClass = Repository.class,
        sqlSessionFactoryRef = MasterDatabaseAutoConfiguration.DATABASE_PREFIX + "SqlSessionFactory")
@EnableConfigurationProperties({MybatisPlusProperties.class})
@ConditionalOnExpression("!'DATASOURCE'.equals('${lamp.database.multiTenantType}')")
public class MasterDatabaseAutoConfiguration extends BaseDatabaseConfiguration {
    /**
     * 每个数据源配置不同即可
     */
    public static final String DATABASE_PREFIX = "master";

    public MasterDatabaseAutoConfiguration(MybatisPlusMasterProperties properties,
                                           DatabaseProperties databaseProperties,
                                           ObjectProvider<Interceptor[]> interceptorsProvider,
                                           ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                           ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                           ResourceLoader resourceLoader,
                                           ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                           ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                           ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                           ApplicationContext applicationContext) {
        super(BeanUtil.toBean(properties, MybatisPlusProperties.class), databaseProperties, interceptorsProvider, typeHandlersProvider,
                languageDriversProvider, resourceLoader, databaseIdProvider,
                configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
        log.debug("检测到 lamp.database.multiTenantType!=DATASOURCE，加载了 NoneMultipleDataSourcesDatabaseAutoConfiguration");
    }

    @Bean(DATABASE_PREFIX + "SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier(DATABASE_PREFIX + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null) {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        } else {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * 数据源信息
     *
     * @return Druid数据源
     */
    @Bean(name = DATABASE_PREFIX + "DruidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = DATABASE_PREFIX + "DataSource")
    public DataSource dataSource(@Qualifier(DATABASE_PREFIX + "DruidDataSource") DataSource dataSource) {
        if (databaseProperties.getP6spy()) {
            return new P6DataSource(dataSource);
        } else {
            return dataSource;
        }
    }

    /**
     * mybatis Sql Session 工厂
     *
     * @return sql链接工厂
     * @throws Exception 异常
     */
    @Bean(DATABASE_PREFIX + "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource) throws Exception {
        return super.sqlSessionFactory(dataSource);
    }

    /**
     * 数据源事务管理器
     *
     * @return 数据源事务管理器
     */
    @Bean(name = DATABASE_PREFIX + "TransactionManager")
    @Primary
    public DataSourceTransactionManager dsTransactionManager(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
