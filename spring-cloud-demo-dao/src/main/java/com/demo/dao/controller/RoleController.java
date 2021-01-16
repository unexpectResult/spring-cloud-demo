package com.demo.dao.controller;

import com.demo.commons.domain.system.Result;
import com.demo.commons.util.RedisUtils;
import com.demo.commons.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping("/isPermit/{username}")
    public Result isPermit(@PathVariable String username){

        System.out.println(username);
        return ResultUtils.success(true);

    }

}
