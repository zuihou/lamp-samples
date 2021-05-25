# lamp 快速开发平台

[![AUR](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/zuihou/lamp-cloud/blob/master/LICENSE)
[![](https://img.shields.io/badge/作者-zuihou-orange.svg)](https://github.com/zuihou)
[![](https://img.shields.io/badge/版本-3.2.2-brightgreen.svg)](https://github.com/zuihou/lamp-cloud)
[![GitHub stars](https://img.shields.io/github/stars/zuihou/lamp-cloud.svg?style=social&label=Stars)](https://github.com/zuihou/lamp-cloud/stargazers)
[![star](https://gitee.com/zuihou111/lamp-cloud/badge/star.svg?theme=white)](https://gitee.com/zuihou111/lamp-cloud/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/zuihou/lamp-cloud.svg?style=social&label=Fork)](https://github.com/zuihou/lamp-cloud/network/members)
[![fork](https://gitee.com/zuihou111/lamp-cloud/badge/fork.svg?theme=white)](https://gitee.com/zuihou111/lamp-cloud/members)

# lamp 项目名字由来

`灯灯`(简称灯， 英文名：lamp)，他是一个项目的统称，由"工具集"、"后端"、"前端"组成，包含以下几个子项目

[点我了解项目详细介绍](简介.md)

## 工具集

| 项目 | gitee | github | 备注 |
| --- | --- | --- | --- |
| lamp-util | https://gitee.com/zuihou111/lamp-util | https://github.com/zuihou/lamp-util | 核心工具集 |
| lamp-generator | https://gitee.com/zuihou111/lamp-generator | https://github.com/zuihou/lamp-generator | 代码生成器 |
| lamp-job | https://gitee.com/zuihou111/lamp-job | https://github.com/zuihou/lamp-job | 分布式定时调度器 |

## 后端

| 项目 | gitee | github | 备注 |
| --- | --- | --- | --- |
| lamp-cloud | https://gitee.com/zuihou111/lamp-cloud | https://github.com/zuihou/lamp-cloud | SpringCloud(微服务)版 |
| lamp-boot | https://gitee.com/zuihou111/lamp-boot | https://github.com/zuihou/lamp-boot | SpringBoot(单体)版 |

## 前端

| 项目 | gitee | github | 备注 | 演示地址 |
| --- | --- | --- | --- | --- |
| lamp-web | https://gitee.com/zuihou111/lamp-web | https://github.com/zuihou/lamp-web | 基于 vue-admin-element (element-ui) | http://tangyh.top:10000 |
| lamp-web-plus(强烈推荐！👏👏👏) | https://gitee.com/zuihou111/lamp-web-plus | https://github.com/zuihou/lamp-web-plus | 基于 vue-vben-admin （vue 3 + ant design vue 2） | http://tangyh.top:3100 |
| lamp-web-beautiful(暂时停更) | https://gitee.com/zuihou111/lamp-web-beautiful | https://github.com/zuihou/lamp-web-beautiful | 基于 vue-admin-beautiful | http://tangyh.top:180 |

# lamp-samples 简介

`lamp-samples`只是`lamp`项目的其中一个实例项目，她注意用于编写lamp-cloud项目中的各种常用示例，截止目前已经完善了如下示例：

- lamp-seata:  分布式事务使用
- lamp-noneMultipleDataSources: None模式配置多数据源，实现不同package下的Mapper调用不同的数据源（且支持Spring本地事务）
- lamp-example： 缓存(lamp-cache-stater)使用示例、自动回显(lamp-echo-stater)示例、URI权限示例、前后端统一表单验证示例等

> 若您对本项目还有什么不明白的地方，或者想要实现的功能，可以留言或者提issue，我会继续完善本项目的示例工程

# lamp 会员版项目演示地址

- lamp-web-plus演示地址： http://tangyh.top:3100
- lamp-web演示地址： http://tangyh.top:10000/lamp-web
- lamp-web-beautiful演示地址： http://tangyh.top:180
- 以下内置账号仅限于内置的0000租户
- 平台管理员： lamp_pt/lamp (内置给公司内部运营人员使用)
- 超级管理员： lamp/lamp
- 普通管理员： general/lamp
- 普通账号： normal/lamp

# 快速上手

- 入门到精通，参考文档： https://www.kancloud.cn/zuihou/zuihou-admin-cloud
- 发现bug和建议，请提交issue： https://github.com/zuihou/lamp-cloud/issues
- 常见问题，请参考Discussions： https://github.com/zuihou/lamp-cloud/discussions

# 会员版

本项目分为开源版和会员版，github和gitee上能搜索到的为开源版本，遵循Apache协议。 会员版源码在私有gitlab托管，购买后开通账号。

会员版和开源版区别请看：[会员版](https://www.kancloud.cn/zuihou/zuihou-admin-cloud/2074547)

