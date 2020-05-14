# springcloud
该项目为自己结合尚硅谷阳哥讲师分享的cloud相关视频，编写的springcloud相关组件的使用实例。感谢尚硅谷和阳哥的分享！
## 服务注册中心
eureka涉及模块：
```$xslt
注册中心
cloud-eureka-server7001
cloud-eureka-server7002
服务提供者
cloud-provider-payment8001
cloud-provider-payment8002
服务消费者
cloud-consumer-order80
```
zookeeper涉及模块
```$xslt
单机版
docker安装zookeeper
docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper:latest
服务提供者
cloud-provider-payment8003
服务消费者
cloud-consumerzk-order80
```
consul涉及模块
```$xslt
单机版 
docker安装consul 
docker run -d --restart=always -p 8500:8500 -e CONSUL_BIND_INTERFACE='eth0' --name=consulone consul agent -server -bootstrap -ui -client=‘0.0.0.0'
服务提供者
cloud-provider-payment8004
服务消费者
cloud-consumerconsul-order80
```

## 服务调用
ribbon涉及模块
```$xslt
cloud-consumer-order80
选择jar自带的负载规则
创建自定义的bean组件MySelfRule
启动主类添加注解
@RibbonClient(name = "调用服务名称",configuration = MySelfRule.class)

自定义负载算法实现
com.gguoliang.order.lb
```
Openfeign涉及模块
```$xslt
cloud-consumerfeign-order80
接口和注解服务调用
超时时间控制 默认时间是1秒
feign日志级别打印
```

##服务降级、熔断、限流
Hystrix涉及模块
```$xslt
服务降级
消费者
cloud-consumer-feign-hystrix-order80
生产者
cloud-provider-hystrix-payment8001

服务熔断
生产者
cloud-provider-hystrix-payment8001
```
HystrixDashboard
```$xslt
cloud-provider-hystrix-payment8001
```
Gateway涉及模块
```$xslt
cloud-gateway-gateway9527
主要涉及路由route 断言predicates 和过滤器 filter
俩种路由方式，断言正则匹配和自定义过滤器
```
config和bus消息总线涉及模块
```$xslt
服务总线
cloud-config-center3344
服务分支
cloud-config-client3355
cloud-config-client3366
```