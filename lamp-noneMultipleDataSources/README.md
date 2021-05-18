本模块仅仅演示None模式，多数据源功能。 适用于不同mapper包，调用不同的数据源的场景。

通常用于定时任务、从不同数据源同步数据等场景下。

重点看以下类和配置文件
- MasterDatabaseAutoConfiguration：第一个数据源的配置类
```
    // 不同点1 
    basePackages = {"com.tangyh.lamp.noneMultipleDataSources.dao.master"}
    /**
     * 不同点2：每个数据源配置不同即可
     */
    public static final String DATABASE_PREFIX = "master";
```
- MybatisPlusMasterProperties：第一个数据源的配置文件类
```
// 相对于MybatisPlusProperties，仅仅这里不一样，表示从配置文件中 mybatis-plus-master.xxx 读取配置
@ConfigurationProperties(prefix = "mybatis-plus-master")
```    
- SlaveDatabaseAutoConfiguration：第二个数据源的配置类
```
    // 不同点1 
    basePackages = {"com.tangyh.lamp.noneMultipleDataSources.dao.slave"}
    /**
     * 不同点2：每个数据源配置不同即可
     */
    public static final String DATABASE_PREFIX = "slave";
```  
- MybatisPlusSlaveProperties：第二个数据源的配置文件类
```
// 相对于MybatisPlusProperties，仅仅这里不一样，表示从配置文件中 mybatis-plus-slave.xxx 读取配置
@ConfigurationProperties(prefix = "mybatis-plus-slave")
```    
- application.yml
```
spring:
  datasource:
    druid:
        # 数据源1操作 lamp_base_0000库
      master: 
        url: jdbc:mysql://${lamp.mysql.ip}:${lamp.mysql.port}/lamp_base_0000?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true
    
        # 数据源2操作 lamp_extend_0000库
      slave:
        url: jdbc:mysql://${lamp.mysql.ip}:${lamp.mysql.port}/lamp_extend_0000?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true
        
# 数据源2的mybatis-plus配置，启动时，会注入到MybatisPlusSlaveProperties中      
mybatis-plus-slave:
  mapper-locations:
    - classpath*:mapper_**/**/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.tangyh.lamp.*.entity;com.tangyh.basic.database.mybatis.typehandler
  typeEnumsPackage: com.tangyh.lamp.*.enumeration
  global-config:
    db-config:
      id-type: INPUT
      insert-strategy: NOT_NULL
      update-strategy: NOT_NULL
      select-strategy: NOT_EMPTY
  configuration:
    #配置返回数据库(column下划线命名&&返回java实体是驼峰命名)，自动匹配无需as（没开启这个，SQL需要写as： select user_id as userId）
    map-underscore-to-camel-case: true
    cache-enabled: false
    #配置JdbcTypeForNull, oracle数据库必须配置
    jdbc-type-for-null: 'null'        

# 数据源1的mybatis-plus配置，启动时，会注入到MybatisPlusMasterProperties中
mybatis-plus-master: # 仅仅这里不同
  mapper-locations:
    - classpath*:mapper_**/**/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.tangyh.lamp.*.entity;com.tangyh.basic.database.mybatis.typehandler
  typeEnumsPackage: com.tangyh.lamp.*.enumeration
  global-config:
    db-config:
      id-type: INPUT
      insert-strategy: NOT_NULL
      update-strategy: NOT_NULL
      select-strategy: NOT_EMPTY
  configuration:
    #配置返回数据库(column下划线命名&&返回java实体是驼峰命名)，自动匹配无需as（没开启这个，SQL需要写as： select user_id as userId）
    map-underscore-to-camel-case: true
    cache-enabled: false
    #配置JdbcTypeForNull, oracle数据库必须配置
    jdbc-type-for-null: 'null'  
```
