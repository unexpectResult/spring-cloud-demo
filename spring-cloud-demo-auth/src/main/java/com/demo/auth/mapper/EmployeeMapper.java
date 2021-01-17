package com.demo.auth.mapper;


import com.demo.commons.domain.system.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface EmployeeMapper {

    public Employee queryEmployeeByUserId(Integer userId);

    public Integer countDepartmentEmployee(Map map);

    public List<Employee> queryEmployeeAddressByDepartmentId(Map map);

    public Employee queryUserDepartment(Integer employeeId);

    //查询员工
    public List<Employee> queryEmployeeDepartment();

    public List<Employee> queryEmployeeByDepartmentId(Integer departmentId);
    //通过Id查询员工
    public Employee queryEmployeeById(Integer employeeId);
    //通过Name查询员工
    public Employee queryEmployeeByName(String employeeName);
    //增加员工
    public int addEmployee(Map<String, Object> employeeMap);

    public Integer addUserEmployee(Map map);
    //修改员工
    public int updateEmployee(Map<String, Object> employeeMap);
    //删除员工
    public void deleteEmployee(Integer[] employeeId);

    public Employee queryEmployeeAllById(Integer integer);

    public int updateEmployeeDepartment(Map map);

}
