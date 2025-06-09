package com.caiocaminha.javadailyexpenses.core.application.gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController // stereotype annotation that combines @Controller and @ResponseBody
@RequestMapping("/v1/transactions")
public class TransactionController {



    @PostMapping("/statement")
    public void createTransactionFromStatement(
            @RequestParam("statement") MultipartFile statement
    ) {


    }


}
