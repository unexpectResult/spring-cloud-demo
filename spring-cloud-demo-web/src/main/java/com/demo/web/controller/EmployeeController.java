package com.demo.web.controller;

import com.demo.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/staffInfo_test")
    public HashMap tolist(@RequestParam(value = "query",required = false)String query,
                          @RequestParam("pagenum")Integer pagenum,
                          @RequestParam("pagesize")Integer pagesize){
        HashMap hashMap = employeeService.tolist(query, pagenum, pagesize);
        return hashMap;
    }

    @GetMapping("/emp/queryEmployee_test")
    public HashMap queryEmployee(){
        HashMap hashMap = employeeService.queryEmployee();
        return hashMap;
    }

    @GetMapping("/addressBook_test")
    public HashMap getDepartmentAddressBook(@RequestBody Map map){
        HashMap hashMap = employeeService.getDepartmentAddressBook(map);
        return hashMap;
    }

    @GetMapping("/emp/queryEmployeeByDepartmentId_test")
    public HashMap queryEmployeeByDepartmentId(@RequestParam("departmentId") Integer departmentId){
        HashMap hashMap = employeeService.queryEmployeeByDepartmentId(departmentId);
        return hashMap;
    }

    @GetMapping("/emp/updateEmployee_test")
    public HashMap toupdate(@RequestParam("id")Integer id){
        HashMap hashMap = employeeService.toupdate(id);
        return hashMap;
    }

    @GetMapping("/emp/deleteEmployee_test")
    public HashMap delete(@RequestParam("id")Integer[] id){
        HashMap hashMap = employeeService.delete(id);
        return hashMap;
    }

    @GetMapping("/emp/addEmployee_test")
    public  HashMap add(@RequestBody Map map){
        HashMap hashMap = employeeService.add(map);
        return hashMap;
    }

    @GetMapping("/emp/toupdate_test")
    public  HashMap update(@RequestBody Map map){
        HashMap hashMap = employeeService.update(map);
        return hashMap;
    }
}
