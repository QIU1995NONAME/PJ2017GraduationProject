# PJ2017GraduationProject

本人的本科毕业设计。采用AGPL3协议开源。

## 使用工具来加速开发

+ [SDKMAN](https://sdkman.io/)
  - Java
  - Gradle
  - Kotlin
  - SpringBoot
+ [NVM](https://github.com/nvm-sh/nvm)
  - Node JS

```bash

sdk update                         # 升级 SDKMAN 自己
sdk upgrade                        # 升级 SDKMAN 管理的软件

sdk install kotlin                 # 使用 SDKMAN 安装工具
sdk install gradle
sdk install springboot

nvm install --lts                  # 使用 NVM 安装 NodeJS LTS
nvm list                           # 列出 NVM 管理的 NodeJS 版本

```

## 常用命令

### Java

```bash
gradle init                        # 初始化一个 gradle 项目
```

### Web App

```bash
npm install -g yarn                # 安装 Yarn
npm install -g @vue/cli            # 安装 Vue CLI

vue  create "project-name"         # 在当前目录创建 Vue 工程

# 在工程目录里面
vue  add vuex                      # 添加 Vue 插件
vue  add router
vue  add bootstrap

yarn add echarts                   # 添加依赖

yarn install                       # Project setup
yarn serve                         # Develop Run
yarn build                         # Production
yarn lint                          # Lints and Fixes

```
