package com.caiocaminha.javadailyexpenses.core.usecase;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;
import com.caiocaminha.javadailyexpenses.core.domain.port.TransactionDetailsPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CreateTransactionUseCase {

    private TransactionDetailsPort transactionDetailsPort;

    public CreateTransactionUseCase(TransactionDetailsPort transactionDetailsPort) {
        this.transactionDetailsPort = transactionDetailsPort;
    }

//    public List<TransactionDetails> executeForMultipartFile(
//            MultipartFile multipartFile
//    ) {
//
//    }

    public void execute("name") {
        transactionDetailsPort.upsert(
                new TransactionDetails(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        Category.MARKET,
                        "details",
                        10.0,
                        LocalDate.now(),
                        "me",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

}
