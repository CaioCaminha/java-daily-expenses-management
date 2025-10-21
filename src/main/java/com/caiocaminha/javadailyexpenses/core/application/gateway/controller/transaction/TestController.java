package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction;

import com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction.dto.TestingRequestDto;
import com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction.dto.TestingResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/testing")
public class TestController {

    @PostMapping
    public TestingResponseDto jsonController(
            @RequestBody TestingRequestDto requestBody
            ) {

        System.out.println("Container it's starting up");

        return new TestingResponseDto(
                requestBody.id(),
                requestBody.date().toString()
        );
    }

}



