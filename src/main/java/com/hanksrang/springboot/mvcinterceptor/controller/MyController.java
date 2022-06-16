package com.hanksrang.springboot.mvcinterceptor.controller;

import com.hanksrang.springboot.mvcinterceptor.pojo.QueryParams;
import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/my")
@Log
public class MyController {

    @RequestMapping( value = "/query", method = RequestMethod.POST)
    public String query(@RequestBody(required = false) @Validated QueryParams queryParams) {
        log.info("in method");
        return null;
    }

}
