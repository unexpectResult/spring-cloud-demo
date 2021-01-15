package com.demo.auth.mapper;

import com.demo.auth.domain.system.User;
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



}
