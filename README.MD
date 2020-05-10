# springcloud
该项目为springcloud相关组件的使用实例
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
docker安装zookeeper 单机版
docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper:latest
服务提供者
cloud-provider-payment8003
服务消费者
cloud-consumerzk-order80
```