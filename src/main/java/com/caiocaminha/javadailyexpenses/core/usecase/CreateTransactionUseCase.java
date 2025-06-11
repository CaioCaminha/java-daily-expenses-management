package com.caiocaminha.javadailyexpenses.core.usecase;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CreateTransactionUseCase {

    public List<TransactionDetails> executeForMultipartFile(
            MultipartFile multipartFile
    ) {

    }


}
