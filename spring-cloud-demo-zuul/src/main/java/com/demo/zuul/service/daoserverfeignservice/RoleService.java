package com.demo.zuul.service.daoserverfeignservice;

import com.demo.commons.domain.system.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "dao-server")
// ,url = "http://127.0.0.1:8002/"

public interface RoleService {

    @GetMapping("/role/isPermit/{username}")
    Result isPermit(@PathVariable String username);


}
