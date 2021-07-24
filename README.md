# lamp 快速开发平台

[![Language](https://img.shields.io/badge/语言-Java%20%7C%20SpringCloud%20%7C%20Vue3%20%7C%20...-red?style=flat-square&color=42b883)](https://github.com/zuihou/lamp-cloud)
[![License](https://img.shields.io/github/license/zuihou/lamp-cloud?color=42b883&style=flat-square)](https://github.com/zuihou/lamp-cloud/blob/master/LICENSE)
[![Author](https://img.shields.io/badge/作者-zuihou-orange.svg)](https://github.com/zuihou)
[![Version](https://img.shields.io/badge/版本-3.3.0-brightgreen.svg)](https://github.com/zuihou/lamp-cloud)
[![Star](https://img.shields.io/github/stars/zuihou/lamp-cloud?color=42b883&logo=github&style=flat-square)](https://github.com/zuihou/lamp-cloud/stargazers)
[![Fork](https://img.shields.io/github/forks/zuihou/lamp-cloud?color=42b883&logo=github&style=flat-square)](https://github.com/zuihou/lamp-cloud/network/members)
[![Star](https://gitee.com/zuihou111/lamp-cloud/badge/star.svg?theme=gray)](https://gitee.com/zuihou111/lamp-cloud/stargazers)
[![Fork](https://gitee.com/zuihou111/lamp-cloud/badge/fork.svg?theme=gray)](https://gitee.com/zuihou111/lamp-cloud/members)

# lamp 项目名字由来
`灯灯`(简称灯， 英文名：lamp)，他是一个项目的统称，由"工具集"、"后端"、"前端"组成，包含以下几个子项目

## 工具集

| 项目 | gitee | github | 备注 |
| --- | --- | --- | --- |
| lamp-util | [lamp-util](https://gitee.com/zuihou111/lamp-util) | [lamp-util](https://github.com/zuihou/lamp-util) | 核心工具集 |
| lamp-generator | [lamp-generator](https://gitee.com/zuihou111/lamp-generator) | [lamp-generator](https://github.com/zuihou/lamp-generator) | 代码生成器 |
| lamp-job | [lamp-job](https://gitee.com/zuihou111/lamp-job) | [lamp-job](https://github.com/zuihou/lamp-job) | 分布式定时调度器 |

## 后端

| 项目 | gitee | github | 备注 |
| --- | --- | --- | --- |
| lamp-cloud | [lamp-cloud](https://gitee.com/zuihou111/lamp-cloud) |  [lamp-cloud](https://github.com/zuihou/lamp-cloud) | SpringCloud(微服务)版 |
| lamp-boot | [lamp-boot](https://gitee.com/zuihou111/lamp-boot) |  [lamp-boot](https://github.com/zuihou/lamp-boot) | SpringBoot(单体)版 |
| 微服务版示例 | [lamp-samples](https://github.com/zuihou/lamp-samples) | [lamp-samples](https://github.com/zuihou/lamp-samples) | 常用示例 |

## 前端

| 项目 | gitee | github | 备注 | 演示地址 |
| --- | --- | --- | --- | --- |
| lamp-web-plus(强烈推荐！👏👏👏) | [lamp-web-plus](https://gitee.com/zuihou111/lamp-web-plus) | [lamp-web-plus](https://github.com/zuihou/lamp-web-plus) | 基于 vue-vben-admin （vue 3 + ant design vue 2） | https://tangyh.top |
| lamp-web | [lamp-web](https://gitee.com/zuihou111/lamp-web) | [lamp-web](https://github.com/zuihou/lamp-web) | 基于 vue-admin-element (element-ui) | https://tangyh.top/lamp-web |
| lamp-web-beautiful(停更) | [lamp-web-beautiful](https://gitee.com/zuihou111/lamp-web-beautiful) | [lamp-web-beautiful](https://github.com/zuihou/lamp-web-beautiful) | 基于 vue-admin-beautiful | 无 |

# lamp-samples 简介

`lamp-samples`只是`lamp`项目的其中一个示例项目，演示了如何使用lamp-util和lamp-cloud，截止目前已经完善了如下示例：

- lamp-seata:  分布式事务使用
- lamp-noneMultipleDataSources: None模式配置多数据源，实现不同package下的Mapper调用不同的数据源（且支持Spring本地事务）
- lamp-example： 缓存(lamp-cache-stater)使用示例、自动回显(lamp-echo-stater)示例、URI权限示例、前后端统一表单验证示例等
- lamp-demo： 表单验证使用

> 若您对本项目还有什么不明白的地方，或者想要实现的功能，可以留言或者提issue，我会继续完善本项目的示例工程


# 会员版演示地址
- 后端使用lamp-cloud-plus，前端使用lamp-web-plus。演示地址： https://tangyh.top
- 后端使用lamp-cloud-plus，前端使用lamp-web。演示地址： https://tangyh.top/lamp-web
- 后端使用lamp-boot-plus， 前端使用lamp-web-plus。演示地址： https://boot.tangyh.top
- 后端使用lamp-boot-plus， 前端使用lamp-web。演示地址： https://boot.tangyh.top/lamp-web

# 演示账号
- 以下内置账号仅限于内置的0000租户
- 平台管理员： lamp_pt/lamp (内置给公司内部运营人员使用)
- 超级管理员： lamp/lamp
- 普通管理员： general/lamp
- 普通账号： normal/lamp

# 快速上手
- 入门到精通，参考文档： https://www.kancloud.cn/zuihou/zuihou-admin-cloud
- 发现bug和建议，请提交issue： https://github.com/zuihou/lamp-cloud/issues
- 常见问题，请参考Discussions： https://github.com/zuihou/lamp-cloud/discussions


