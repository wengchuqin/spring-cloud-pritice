package top.chuqin.cloud.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    public User getById(Long id){
        return new UserCommand(restTemplate, id).execute();
    }
}
