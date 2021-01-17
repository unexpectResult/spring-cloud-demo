package com.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "dao-server")
public interface RoleService {
    @GetMapping("/role/queryRole")
    public HashMap queryRole();

    @GetMapping("/role/queryRoleList")
    public HashMap queryRoleList(@RequestParam(value = "query",required = false)String query, @RequestParam("pagenum")Integer pagenum, @RequestParam("pagesize")Integer pagesize);

    @GetMapping("/role/addRole")
    public HashMap add(@RequestBody Map map);

    @GetMapping("/role/updateRole")
    public HashMap toupdate(@RequestParam("id")Integer id);

    @GetMapping("/role/toupdate")
    public  HashMap update(@RequestBody Map map);

    @GetMapping("/role/deleteRole")
    public HashMap delete(@RequestParam("id")Integer[] id);
}
