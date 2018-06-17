- eureka-server模块:<br/>
服务注册中心，负责服务列表的注册、维护和查询等功能;
- eureka-client模块:<br/>
服务提供方，同时也是一个Eureka&nbsp;Client，负责将所提供的服务向eureka-server进行注册、续约和注销等操作。注册时所提供的主要数据包括服务名、机器ip、端口号、域名等，从而能够使服务消费方能够找到;
- ribbon-consumer模块:<br/>
服务消费方，同时也是一个Eureka&nbsp;Client，同样也会向eureka-server注册本身所提供的服务。


