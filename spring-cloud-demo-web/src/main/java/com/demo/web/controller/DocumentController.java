package com.demo.web.controller;
import com.demo.commons.domain.system.Result;
import com.demo.web.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;


    @GetMapping("/doc/documentDetails_test")
    public Result queryProcess(@RequestParam(name = "documentId",required = false)Integer documentId){
        Result result = documentService.queryProcess(documentId);
        System.out.println(result);
        return result;
    }

    @GetMapping("attachment/upload_test")
    public Result fileUploads(HttpServletRequest request, @RequestParam("file") MultipartFile[] files, @RequestParam("documentId") Integer documentId){
        Result result = documentService.fileUploads(request, files, documentId);
        return result;
    }

    @GetMapping("attachment/download_test")
    public ResponseEntity<byte[]> download(HttpServletResponse response, @RequestParam(name = "url",required = false) String url){
        ResponseEntity<byte[]> responseEntity = documentService.download(response, url);
        return responseEntity;
    }

    @GetMapping("/doc/queryDocument_test")
    public HashMap queryDocument(@RequestParam(name = "employeeId",required = false)Integer employeeId,
                                 @RequestParam(value = "query",required = false)String query,
                                 @RequestParam(name = "pagenum",required = false)Integer pagenum,
                                 @RequestParam(name = "pagesize",required = false)Integer pagesize,
                                 @RequestParam(name = "documentLabel",required = false)Integer documentLabel,
                                 @RequestParam(name = "documentCollect",required = false)Integer documentCollect,
                                 @RequestParam(name = "documentStatus",required = false)Integer documentStatus,
                                 @RequestParam(name = "isPublic",required = false)String isPublic
    ){
        HashMap hashMap = new HashMap();
        hashMap = documentService.queryDocument(employeeId, query, pagenum, pagesize, documentLabel, documentCollect, documentStatus, isPublic);
        return hashMap;
    }


    @GetMapping("/doc/examineDocument_test")
    public HashMap queryExamineDocument( @RequestParam(name = "employeeId")Integer employeeId,
                                         @RequestParam(value = "query",required = false)String query,
                                         @RequestParam(name = "pagenum",required = false)Integer pagenum,
                                         @RequestParam(name = "pagesize",required = false)Integer pagesize){
        HashMap hashMap = new HashMap();
        hashMap = documentService.queryExamineDocument(employeeId, query, pagenum, pagesize);
        return hashMap;
    }

    @GetMapping("/doc/addDocument_test")
    public Result addDepartment(@RequestBody Map map){
        Result result = documentService.addDepartment(map);
        return result;
    }

    @GetMapping("/doc/toexamine_test")
    public HashMap examine(@RequestBody Map map){
        HashMap hashmap = documentService.examine(map);
        return hashmap;
    }

    @GetMapping("/doc/toupdate_test")
    public HashMap updateDocument(@RequestBody Map map){
        HashMap hashmap = documentService.updateDocument(map);
        return hashmap;
    }

    @GetMapping("/doc/collect_test")
    public HashMap collectDocument(@RequestBody Map map){
        HashMap hashmap = documentService.collectDocument(map);
        return hashmap;
    }

    @GetMapping("/doc/deleteDocument_test")
    public HashMap todelete(@RequestParam("id")Integer[] id){
        HashMap hashmap = documentService.todelete(id);
        return hashmap;
    }
}

