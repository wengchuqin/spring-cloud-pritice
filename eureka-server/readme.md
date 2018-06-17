# 注册中心

- eureka.client.register-with-eureka<br/>
    是否向注册中心注册自己
- eureka.client.fetch-registry<br/>
    检索注册中心
- eureka.client.service-url.defaultZone <br/>
    指定注册中心地址
- eureka.instance.prefer-ip-address <br/>
    使用主机名（域名）来定义注册中心地址


本模块使用域名来定义注册中心地址，所以需要改host文件，如下所示<br/>
127.0.0.1 peer1 <br/>
127.0.0.1 peer2 <br/>