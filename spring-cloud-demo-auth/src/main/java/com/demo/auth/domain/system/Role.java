package com.demo.auth.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    //角色Id
    private Integer roleId;
    //角色名称
    private String roleName;

    private String roleStatus;

    private String roleCreateTime;

    private String roleRemark;

    private Integer roleLevel;

    //一对多
    private Set<com.demo.auth.domain.system.Permission> permissions = new HashSet<com.demo.auth.domain.system.Permission>(0);
    // private Set<NavigationBar> navigationBars = new HashSet<NavigationBar>(0);
    // private Set<User> users = new HashSet<User>(0);
}