package com.demo.web.service;

import com.demo.commons.domain.system.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "dao-server")
public interface DocumentService {

    @GetMapping("/doc/documentDetails")
    public Result queryProcess(@RequestParam(name = "documentId",required = false)Integer documentId);

    @GetMapping("/attachment/upload")
    public Result fileUploads(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, @RequestParam("documentId") Integer documentId);

    @GetMapping("/attachment/download")
    public ResponseEntity<byte[]> download(HttpServletResponse response, @RequestParam(name = "url",required = false) String url);

    @GetMapping("/doc/queryDocument")
    public HashMap queryDocument(@RequestParam(name = "employeeId",required = false)Integer employeeId,
                                 @RequestParam(value = "query",required = false)String query,
                                 @RequestParam(name = "pagenum",required = false)Integer pagenum,
                                 @RequestParam(name = "pagesize",required = false)Integer pagesize,
                                 @RequestParam(name = "documentLabel",required = false)Integer documentLabel,
                                 @RequestParam(name = "documentCollect",required = false)Integer documentCollect,
                                 @RequestParam(name = "documentStatus",required = false)Integer documentStatus,
                                 @RequestParam(name = "isPublic",required = false)String isPublic
    );

    @GetMapping("/doc/examineDocument")
    public HashMap queryExamineDocument( @RequestParam(name = "employeeId")Integer employeeId,
                                         @RequestParam(value = "query",required = false)String query,
                                         @RequestParam(name = "pagenum",required = false)Integer pagenum,
                                         @RequestParam(name = "pagesize",required = false)Integer pagesize);

    @GetMapping("/doc/addDocument")
    public Result addDepartment(@RequestBody Map map);

    @GetMapping("/doc/toexamine")
    public HashMap examine(@RequestBody Map map);

    @GetMapping("/doc/toupdate")
    public HashMap updateDocument(@RequestBody Map map);

    @GetMapping("/doc/collect")
    public HashMap collectDocument(@RequestBody Map map);

    @GetMapping("/doc/deleteDocument")
    public HashMap todelete(@RequestParam("id")Integer[] id);
}
