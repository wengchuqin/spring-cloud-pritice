本模块通过注册中心消费了hello-service服务。<br/>
消费者只需要知道服务名，而不需要知道具体地址，在服务治理框架中，这是一个非常重要的特性。<br/>
本模块还支持Hystrix(降级，熔断)<br/>
本模块还支持Hystrix dashboard，management.endpoints.web.exposure.include=hystrix.stream<br/>

