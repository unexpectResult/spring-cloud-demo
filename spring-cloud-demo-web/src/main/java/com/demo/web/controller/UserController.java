package com.demo.web.controller;

import com.demo.commons.domain.system.Result;
import com.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/update_test")
    public Result updateUser(@RequestBody Map map){
        Result result = userService.updateUser(map);
        return result;
    }

    @GetMapping("/user/queryUserById_test")
    public Result queryUserById(@RequestParam("userId") Integer userId){
        Result result = userService.queryUserById(userId);
        return result;
    }
}
