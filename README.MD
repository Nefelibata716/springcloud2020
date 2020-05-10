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