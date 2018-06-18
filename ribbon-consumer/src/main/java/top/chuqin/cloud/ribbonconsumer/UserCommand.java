package top.chuqin.cloud.ribbonconsumer;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class UserCommand extends HystrixCommand<User> {
    public static Logger LOGGER = LoggerFactory.getLogger(UserCommand.class);

    private RestTemplate restTemplate;
    private Long id;

    protected UserCommand(RestTemplate restTemplate, Long id) {
        super(HystrixCommandGroupKey.Factory.asKey("user"));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    /**
     * 降级操作
     *
     * @return
     */
    @Override
    protected User getFallback() {
        //异常处理
        Throwable throwable = getExecutionException();
        LOGGER.info("调用USER-SERVICE服务出错", throwable);

        return new User();
    }


    /**
     * 定义请求缓存的key
     * @return
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

}
