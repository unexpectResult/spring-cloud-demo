package com.demo.web.controller;

import com.demo.web.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcessController {
    @Autowired
    ProcessService processService;
    @GetMapping("/pro/queryProcess_test")
    public HashMap queryProcess(@RequestParam(name = "documentId",required = false)Integer documentId){
        HashMap hashMap = processService.queryProcess(documentId);
        return hashMap;
    }

    @GetMapping("/pro/updateProcess_test")
    public HashMap updateProcess(@RequestBody Map map){
        HashMap hashMap = processService.updateProcess(map);
        return hashMap;
    }

    @GetMapping("/pro/deleteProcess_test")
    public HashMap deleteProcess(@RequestParam("processId")Integer processId){
        HashMap hashMap = processService.deleteProcess(processId);
        return hashMap;
    }
}
