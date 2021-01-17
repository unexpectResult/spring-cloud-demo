package com.demo.web.controller;

import com.demo.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @GetMapping("/pem/queryPermission_test")
    public HashMap queryPermission(){
        HashMap hashMap = permissionService.queryPermission();
        return hashMap;
    }

    @GetMapping("/permission/toadd_test")
    public String toadd(){
        String string = permissionService.toadd();
        return string;
    }

    @GetMapping("/permission/toupdate_test")
    public String toupdate(){
        String string = permissionService.toupdate();
        return string;
    }

    @GetMapping("/permission/delete_test")
    public String delete(){
        String string = permissionService.delete();
        return string;
    }

    @GetMapping("/permission/add_test")
    public  String add(){
        String string = permissionService.add();
        return string;
    }

    @GetMapping("/permission/update_test")
    public  String update(){
        String string = permissionService.update();
        return string;
    }
}
