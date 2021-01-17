package com.demo.auth.mapper;

import com.demo.commons.domain.system.Employee;
import com.demo.commons.domain.system.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 登录
     *
     * @param username 用户名
     * @return
     */
    User login(String username);

    Employee queryEmployee(Integer userId);


}
