package com.reindefox.homelibraryserver.controller;

import com.reindefox.homelibraryserver.domain.dto.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionTestController {

    /**
     * Проверка соединения с сервером
     * @return статус соединения
     */
    @RequestMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public TestResponse test() {
        return new TestResponse("ok");
    }
}
