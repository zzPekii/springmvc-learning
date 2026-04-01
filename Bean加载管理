# Bean加载控制

*要把“负责界面的（Controller）”和“负责逻辑的（Service/Dao）”分开管理。*

# 1. 为什么要分两个容器？

一个标准的 SSM 项目有两个“管家”：

- **SpringMVC 容器（子容器）**：专门管表现层（Controller），负责接收请求。
- **Spring 容器（父容器）**：专门管业务层（Service）和持久层（Dao），负责处理逻辑。
- **原则**：为了职责清晰，**子容器不扫业务 Bean，父容器不扫表现层 Bean**。

# 2. 包扫描控制方案

假设基础包路径是 `com.harris`。

- **SpringMVC 的职责**：
    - **扫描范围**：精确到 `com.harris.controller`。
    - **加载对象**：`@Controller` 相关的 Bean。
- **Spring 的职责（两种写法）**：
    - **方式一：排除法（推荐）**
        - 扫描 `com.harris` 全包，但设置 `exclude-filter`（排除过滤器）。
        - **排除目标**：标注了 `@Controller` 的类。
    - **方式二：精准扫描**
        - 分别指定扫描 `com.harris.service` 和 `com.harris.dao`。
    - 方式三：不区分Spring和SpringMVC的环境

# 3. 为什么不“一把梭”全部扫描？

如果 Spring 容器也扫描了 Controller：

1. **内存浪费**：同一个 Controller 会在两个容器里各存一个。
2. **事务失效**：Spring 的事务增强通常只加在它自己扫描到的 Service 上。如果 Controller 被 Spring 扫描了，可能会导致依赖注入关系错乱，导致事务不生效。

# 4. ComponentScan

在config类中

```java
@Configuration // 1. 必须有这个，告诉 Spring 这是个配置类
//@ComponentScan(value = "com.harris", // 2. 确保路径和你左侧目录完全一致
//        excludeFilters = @ComponentScan.Filter(
//                type = FilterType.ANNOTATION,
//                classes = Controller.class
//        )
//)
@ComponentScan({"com.harris.service", "com.harris.dao"})
public class SpringConfig {
}
```

excludeFilters 排除扫描路径中加载的bean，需要制定类别与具体项

includeFilters 加载指定bean，需要制定类别与具体项

# 5. 跟简化的servlet类搭配

继承 `AbstractAnnotationConfigDispatcherServletInitializer` 类，只需要把类写入进去即可

```java
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
```