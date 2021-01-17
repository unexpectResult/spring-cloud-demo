package com.demo.web.service;

import com.demo.commons.domain.system.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "dao-server")
public interface UserService {
    @GetMapping("/user/update")
    public Result updateUser(@RequestBody Map map);

    @GetMapping("/user/queryUserById")
    public Result queryUserById(@RequestParam("userId") Integer userId);

}
