package com.caiocaminha.javadailyexpenses.core.application.gateway.controller;

import com.caiocaminha.javadailyexpenses.core.usecase.CreateTransactionUseCase;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */

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
        /**
         * Practical example of how to implement virtual threads on a real application
         */
        Thread.ofVirtual().start(
                () -> {
                    createTransactionUseCase.execute();
                }
        ).start();

        /**
         * Example using ExecutorService
         */
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(() -> {
                createTransactionUseCase.execute();
            }).get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
