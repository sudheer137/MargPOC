package com.marg.margpoc.controller;

import com.marg.margpoc.services.OutstandingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/data")
@Slf4j
public class OutstandingController {
    private final OutstandingServices outstandingServices;
    public OutstandingController(OutstandingServices outstandingServices) {
        this.outstandingServices = outstandingServices;
    }
    @PostMapping("/marg")
    public ResponseEntity<String> dataMarg(@RequestParam("file") MultipartFile[] multipartFiles){

       String response =outstandingServices.save(multipartFiles);

        return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("%s",response ));
    }
}
