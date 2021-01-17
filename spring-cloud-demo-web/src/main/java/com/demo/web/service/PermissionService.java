package com.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@FeignClient(value = "dao-server")
public interface PermissionService {
    @GetMapping("/pem/queryPermission")
    public HashMap queryPermission();

    @GetMapping("/permission/toadd")
    public String toadd();

    @GetMapping("/permission/toupdate")
    public String toupdate();

    @GetMapping("/permission/delete")
    public String delete();

    @GetMapping("/permission/add")
    public  String add();

    @GetMapping("/permission/update")
    public  String update();

}
