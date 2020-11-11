package com.cloud.service.client;

import com.cloud.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author wangquan
 * @date 2020/11/11
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("不好意思，系统繁忙！");
        return user;
    }
}
