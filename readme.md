##微服务学习demo
###Eureka      注册中心
- 1、pom需要添加
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
```
- 2、主启动类添加
```java
@EnableEurekaServer
```
- 3、本地集群环境需要修改Hosts文件
```text
C:\Windows\System32\drivers\etc

添加host映射

127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
127.0.0.1 eureka7003.com

```
- 4、yml文件配置
```xml
server:
  port: 7001

eureka:
  instance:
    #此处的hostname 对应hosts中配置的域名
    hostname: eureka7001.com
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      #demo环境是 双机集群办 7001 和 7002 7001环境下 defaultZone 对应7002的Zone配置
      defaultZone: http://eureka7002.com:7002/eureka/
```

- 5、 客户端pom文件
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

- 6、客户端yml文件
```xml
eureka:
  client:
    service-url:
      #对应 eureka 集群服务的空间地址
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

- 7、主启动类添加配置
```java
@EnableEurekaClient
```
###Ribbon      负载均衡
```spring cloud 负载均衡为软负载 通过调用放 通过轮询算法在服务之间切换调用```
- 1、服务端yml配置
```xml
spring: 
  application: 
    name: provider-dept  #服务端spring.application.name 名称需要一致 使用RestTemplate调用时可以通过该名称进行访问服务
```
- 2、客户端调用方添加配置
```java
    @Bean
    //负载均衡请求
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
```
- 3、调用示例
```java
    @Autowired
    private RestTemplate restTemplate;

    //private final String REST_URL_PREFIX="http://localhost:8002/";
    //负载均衡方式调用接口  前缀使用spring.application.name 去eureka 获取服务对象
    private final String REST_URL_PREFIX="http://PROVIDER-DEPT/";


    @RequestMapping("comsumer/dept/list")
    public List<Dept> list(){
        List forObject = restTemplate.getForObject(REST_URL_PREFIX + "/provider/dept/list", List.class);
        return forObject;
    }
```
###Feign       RESTFUL负载均衡
###Hystrix     熔断
```text
熔断是当服务接口调用异常的情况加 通过设置返回友好或者提示信息，避免服务崩溃，也便于开发人员排错
```
- 1、服务端添加pom引用
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId> 
            <!-- hystrix 必选  注意版本选择 不是spring-cloud-starter-hystrix -->
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
```
- 2、主程序类添加启用注解
```java
@EnableHystrix
```
- 3、 熔断接口处理示例
```java
    @Autowired
    private DeptService deptService;

    @RequestMapping("/provider/dept/list")
    //@HystrixCommand 调用的方法的返回值需要和描述的方法一致
    @HystrixCommand(fallbackMethod = "resultError")
    public List<Dept> list(){
        return deptService.list();
    }

    public List<Dept> resultError(){
        List<Dept> list = new ArrayList<>();
        return list;
    }
```
###Zuul        网关
###Config      统一配置管理