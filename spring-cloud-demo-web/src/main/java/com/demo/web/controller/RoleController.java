package com.demo.web.controller;

import com.demo.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/role/queryRole_test")
    public HashMap queryRole(){
        HashMap hashMap = roleService.queryRole();
        return hashMap;
    }

    @GetMapping("/role/queryRoleList_test")
    public HashMap queryRoleList(@RequestParam(value = "query",required = false)String query, @RequestParam("pagenum")Integer pagenum, @RequestParam("pagesize")Integer pagesize){
        HashMap hashMap = roleService.queryRoleList(query, pagenum, pagesize);
        return hashMap;
    }

    @GetMapping("/role/addRole_test")
    public HashMap add(@RequestBody Map map){
        HashMap hashMap = roleService.add(map);
        return hashMap;
    }

    @GetMapping("/role/updateRole_test")
    public HashMap toupdate(@RequestParam("id")Integer id){
        HashMap hashMap = roleService.toupdate(id);
        return hashMap;
    }

    @GetMapping("/role/toupdate_test")
    public  HashMap update(@RequestBody Map map){
        HashMap hashMap = roleService.update(map);
        return hashMap;
    }

    @GetMapping("/role/deleteRole_test")
    public HashMap delete(@RequestParam("id")Integer[] id){
        HashMap hashMap = roleService.delete(id);
        return hashMap;
    }
}
