package com.dw.controller;

import com.dw.dto.RequestLog;
import com.dw.dto.RequestLogResponse;
import com.dw.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/log")
@RequiredArgsConstructor
public class RequestAPI {

    private final RequestService requestService;

    @GetMapping("/getAllLogs")
    public ResponseEntity<List<RequestLogResponse>> getRequestLogs(){
        return ResponseEntity.ok(this.requestService.getRequestLogs());
    }

    @GetMapping("/getLogsByEntity")
    public ResponseEntity<List<RequestLogResponse>> getRequestLogsByEntity(@RequestParam String entityName){
        return ResponseEntity.ok(this.requestService.getRequestLogsByEntity(entityName));
    }

    @GetMapping("/getLogsByEntityAndId/{entityName}/{id}")
    public ResponseEntity<List<RequestLogResponse>> getRequestLogsByEntityAndId(@PathVariable String entityName, @PathVariable String id){
        return ResponseEntity.ok(this.requestService.getRequestLogsByEntityAndId(entityName, id));
    }

    @GetMapping("/getLogsByStatus")
    public ResponseEntity<List<RequestLogResponse>> getLogsByStatus(@RequestParam int status){
        return ResponseEntity.ok(this.requestService.getLogsByStatus(status));
    }

    @PostMapping
    public ResponseEntity<RequestLogResponse> createRequestLog(@RequestBody RequestLog requestLog){
        return ResponseEntity.ok(this.requestService.createRequestLog(requestLog));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllRequestLogs(){
        this.requestService.deleteAllRequestLogs();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
