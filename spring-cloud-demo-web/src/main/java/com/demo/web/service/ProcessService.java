package com.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "dao-server")
public interface ProcessService {
    @GetMapping("/pro/queryProcess")
    public HashMap queryProcess(@RequestParam(name = "documentId",required = false)Integer documentId);

    @GetMapping("/pro/updateProcess")
    public HashMap updateProcess(@RequestBody Map map);

    @GetMapping("/pro/deleteProcess")
    public HashMap deleteProcess(@RequestParam("processId")Integer processId);
}
