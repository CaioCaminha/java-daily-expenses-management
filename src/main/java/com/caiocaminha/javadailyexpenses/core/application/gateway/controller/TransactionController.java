package com.caiocaminha.javadailyexpenses.core.application.gateway.controller;

import com.caiocaminha.javadailyexpenses.core.usecase.CreateTransactionUseCase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController // stereotype annotation that combines @Controller and @ResponseBody
@RequestMapping("/v1/transactions")
public class TransactionController {

    private CreateTransactionUseCase createTransactionUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
    }



    @PostMapping("/statement")
    public void createTransactionFromStatement(
            @RequestParam("statement") MultipartFile statement
    ) {


    }


}
