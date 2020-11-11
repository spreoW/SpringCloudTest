package com.cloud.service.client;

import com.cloud.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author w
 * @date 2020/11/11
 */
@FeignClient(value = "service-provider",fallback = UserClientFallback.class)  // 标注该类是一个feign接口
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
