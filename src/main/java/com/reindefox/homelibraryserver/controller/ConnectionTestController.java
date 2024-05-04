package com.reindefox.homelibraryserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ConnectionTestController {
    @RequestMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> test() {
        return Collections.singletonMap("status", "ok");
    }
}
