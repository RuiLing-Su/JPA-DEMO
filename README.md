# Spring Boot + JPA CRUD Demo

## 项目简介

本项目是一个使用 **Spring Boot** 和 **JPA (Java Persistence API)** 实现的简单增删查改（CRUD）操作的演示应用。通过该项目，你可以了解如何通过 API 操作 MySQL 数据库中的数据，并实现常见的用户管理操作。

## 功能说明

该项目实现了对用户（`UserInfo`）的以下功能：
- 添加用户（save）
- 查询用户（findAll）
- 更新用户（edit）
- 删除用户（deleteById）

### 具体功能
1. **添加用户**: 通过 POST 请求添加新的用户记录到数据库。
2. **查询用户**: 通过 GET 请求查询单个或多个用户的详细信息。
3. **更新用户**: 通过 PUT 请求更新用户信息并保存到数据库。
4. **删除用户**: 通过 DELETE 请求根据用户 ID 删除数据库中的用户记录。

## 技术栈

本项目使用的技术栈如下：
- **Spring Boot 2.x**：构建基础框架
- **Spring Data JPA**：实现持久层操作
- **MySQL**：持久化数据库
- **Maven**：项目构建与依赖管理
- **Lombok**：简化 Java Bean 开发

## 环境要求

- **JDK 1.8** 及以上
- **Maven 3.6** 及以上
- **MySQL 5.x/8.x**

## 数据库配置

请确保你的 MySQL 数据库已创建，配置文件中默认数据库名称为 `cst`。如果需要更改数据库配置，请修改 `application.yml` 中的以下内容：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cst?useSSL=false
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    database: MYSQL
    show-sql: true
    open-in-view: true
    properties:
      hibernate:
        enable_lazy_load_no_trans: true
        dialect: org.hibernate.dialect.MySQL5Dialect
        ddl-auto: update
```

## 快速开始

### 1. 克隆项目

首先将该项目克隆到本地：

```bash
git clone https://github.com/RuiLing-Su/JPA-DEMO.git
cd JPA-DEMO
```

### 2. 运行项目

项目使用 **Maven** 进行构建，运行以下命令启动项目：

```bash
mvn spring-boot:run
```

项目默认启动在 `http://localhost:8081/` （端口号可在 `application.yml` 中修改）。

### 3. API 接口说明

以下是项目中实现的 CRUD 操作的 REST API 列表：

#### 1. 添加用户
- **URL**: `/users`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "userName": "ruiling的jpa学习03",
      "age": 30,
      "sex": "Male",
      "blogUrl": "http://ruiling.online/archives/mybatis-data-jpa",
      "remark": "Test user"
    }
    ```
- **Response**: 成功创建用户后，返回用户详细信息。

#### 2. 查询用户
- **URL**: `/users/{id}`
- **Method**: `GET`
- **Path Variable**: `id` (用户ID)
- **Response**: 返回指定用户的详细信息。

#### 3. 查询所有用户
- **URL**: `/users`
- **Method**: `GET`
- **Response**: 返回所有用户的列表。

#### 4. 更新用户
- **URL**: `/users/{id}`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
      "userName": "ruiling的jpa学习03",
      "age": 25,
      "sex": "Female",
      "blogUrl": "http://ruiling.online/archives/mybatis-data-jpa",
      "remark": "Updated user"
    }
    ```
- **Response**: 返回更新后的用户信息。

#### 5. 删除用户
- **URL**: `/users/{id}`
- **Method**: `DELETE`
- **Path Variable**: `id` (用户ID)
- **Response**: 成功删除用户后返回状态信息。

## 数据库连接

项目连接的是 **MySQL 数据库**，确保你已经配置好数据库连接并创建了相关表。

### 表结构（`UserInfo`）

```sql
CREATE TABLE IF NOT EXISTS tb_user
(
  user_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号',
  user_name VARCHAR(50) NOT NULL COMMENT '用户姓名',
  blog_url VARCHAR(50) NOT NULL COMMENT '博客地址',
  remark VARCHAR(50) COMMENT '备注'
  ) COMMENT = '用户信息表';
```

## 主要代码结构

- `src/main/java/com/rl/jpademo/`
   - `controller/`：REST API 控制器，处理用户请求。
   - `entity/`：JPA 实体类，用于定义数据库表结构。
   - `dao/`：数据访问层，包含 JPA 接口，用于对数据库进行操作。
   - `service/`：业务逻辑层。

## 扩展功能

该项目可扩展的功能包括：
- 添加用户验证（如表单校验）
- 添加分页和排序功能
- 集成其他数据库，如 PostgreSQL 等

