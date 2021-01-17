package com.demo.web.controller;

import com.demo.web.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/dep/queryEmployeeByRoleLevel_test")
    public HashMap queryDepartment(@RequestBody Map map){
        HashMap hashMap = departmentService.queryDepartment(map);
        return hashMap;
    }

    @GetMapping("/dep/queryDepartmentEmployee_test")
    public HashMap queryDepartmentEmployee(@RequestParam("employeeId") Integer employeeId){
        HashMap hashMap = departmentService.queryDepartmentEmployee(employeeId);
        return hashMap;
    }

    @GetMapping("/dep/queryDepartment_test")
    public HashMap queryDepartment(@RequestParam(value = "id",required = false)Integer id,@RequestParam(value = "query",required = false)String query, @RequestParam(value = "pagenum",required = false)Integer pagenum, @RequestParam(value = "pagesize",required = false)Integer pagesize){
        HashMap hashMap = departmentService.queryDepartment(id, query, pagenum, pagesize);
        return hashMap;
    }

    @GetMapping("/dep/addDepartment_test")
    public HashMap addDepartment(@RequestBody Map map){
        HashMap hashMap = departmentService.addDepartment(map);
        return hashMap;
    }

    @GetMapping("/dep/updateDepartment_test")
    public HashMap toupdate(@RequestParam("id")Integer id){
        HashMap hashMap = departmentService.toupdate(id);
        return hashMap;
    }

    @GetMapping("/dep/toupdate_test")
    public HashMap updateDepartment(@RequestBody Map map){
        HashMap hashMap = departmentService.updateDepartment(map);
        return hashMap;
    }

    @GetMapping("/dep/deleteDepartment_test")
    public HashMap todelete(@RequestParam("id")Integer id){
        HashMap hashMap = departmentService.todelete(id);
        return hashMap;
    }

    @GetMapping("/dep/todelete_test")
    public HashMap deleteDepartment(@RequestBody Map map){
        HashMap hashMap = departmentService.deleteDepartment(map);
        return hashMap;
    }
}
