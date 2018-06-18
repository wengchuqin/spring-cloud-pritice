package top.chuqin.cloud.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private LocalHelloService localHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        StringBuilder sb = new StringBuilder();
        sb.append(localHelloService.hello()).append("\n")
                .append(localHelloService.hello("wengchuqin")).append("\n")
                .append(localHelloService.hello("fangxiaochun", 20)).append("\n")
                .append(localHelloService.hello(new User("wengchuqin", 21))).append("\n");

        return sb.toString();
    }


}
