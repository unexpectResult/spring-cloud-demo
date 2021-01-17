package com.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "dao-server")
public interface EmployeeService {
    @GetMapping("/staffInfo")
    public HashMap tolist(@RequestParam(value = "query",required = false)String query,
                          @RequestParam("pagenum")Integer pagenum,
                          @RequestParam("pagesize")Integer pagesize);

    @GetMapping("/emp/queryEmployee")
    public HashMap queryEmployee();

    @GetMapping("/addressBook")
    public HashMap getDepartmentAddressBook(@RequestBody Map map);

    @GetMapping("/emp/queryEmployeeByDepartmentId")
    public HashMap queryEmployeeByDepartmentId(@RequestParam("departmentId") Integer departmentId);

    @GetMapping("/emp/updateEmployee")
    public HashMap toupdate(@RequestParam("id")Integer id);

    @GetMapping("/emp/deleteEmployee")
    public HashMap delete(@RequestParam("id")Integer[] id);

    @GetMapping("/emp/addEmployee")
    public  HashMap add(@RequestBody Map map);

    @GetMapping("/emp/toupdate")
    public  HashMap update(@RequestBody Map map);
}
