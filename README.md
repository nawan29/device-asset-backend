# 智能设备资产管理系统 - 后端
本项目是一个企业级的前后端分离 Web 应用后端服务。基于 Spring Boot + MyBatis-Plus 搭建，提供设备信息的增删改查 API，并集成了 JWT 身份认证和 Redis 缓存机制。

## 🛠 技术栈
- **核心框架**：Java 17 / Spring Boot 3.x
- **持久层**：MyBatis-Plus / MySQL
- **缓存**：Redis
- **安全认证**：JWT (JSON Web Token)
- **构建工具**：Maven

## ✨ 核心功能
1. **RESTful API**：提供设备资产的增删改查接口，支持跨域请求。
2. **JWT 鉴权**：实现了基于拦截器（Interceptor）的全局 JWT 校验，无状态登录，保护接口安全。
3. **缓存加速**：利用 Redis 缓存高频查询（如设备列表），减轻 MySQL 数据库压力。
4. **统一异常处理**：全局拦截异常，返回标准的 JSON 格式错误信息。

## 🚀 快速启动
1. **准备环境**：确保本地已安装 JDK 17、Maven、MySQL 和 Redis。
2. **初始化数据库**：
   在 MySQL 中新建数据库 `device_db`，并执行 `sql` 目录下的建表语句（如果没有 sql 文件，请在数据库中手动建表）。
3. **修改配置**：
   打开 `src/main/resources/application.properties`，将 `spring.datasource.password` 改为你本地 MySQL 的密码。
4. **启动项目**：
   在 IDEA 中运行 `DeviceAssetSystemApplication`，或者在终端执行：
   ```bash
   mvn spring-boot:run