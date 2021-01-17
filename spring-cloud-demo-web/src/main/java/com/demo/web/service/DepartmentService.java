package com.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "dao-server")
public interface DepartmentService {
    @GetMapping("/dep/queryEmployeeByRoleLevel")
    public HashMap queryDepartment(@RequestBody Map map);

    @GetMapping("/dep/queryDepartmentEmployee")
    public HashMap queryDepartmentEmployee(@RequestParam("employeeId") Integer employeeId);

    @GetMapping("/dep/queryDepartment")
    public HashMap queryDepartment(@RequestParam(value = "id",required = false)Integer id,@RequestParam(value = "query",required = false)String query, @RequestParam(value = "pagenum",required = false)Integer pagenum, @RequestParam(value = "pagesize",required = false)Integer pagesize);

    @GetMapping("/dep/addDepartment")
    public HashMap addDepartment(@RequestBody Map map);

    @GetMapping("/dep/updateDepartment")
    public HashMap toupdate(@RequestParam("id")Integer id);

    @GetMapping("/dep/toupdate")
    public HashMap updateDepartment(@RequestBody Map map);

    @GetMapping("/dep/deleteDepartment")
    public HashMap todelete(@RequestParam("id")Integer id);

    @GetMapping("/dep/todelete")
    public HashMap deleteDepartment(@RequestBody Map map);

}
