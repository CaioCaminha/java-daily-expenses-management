package com.caiocaminha.javadailyexpenses.core.usecase;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.domain.enums.Category;
import com.caiocaminha.javadailyexpenses.core.domain.port.DataExtractorPort;
import com.caiocaminha.javadailyexpenses.core.domain.port.TransactionDetailsPort;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectReader;
import tools.jackson.dataformat.csv.CsvMapper;
import tools.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateTransactionUseCase {

    private static final CsvMapper mapper = new CsvMapper();


    private final TransactionDetailsPort transactionDetailsPort;

    public CreateTransactionUseCase(
            TransactionDetailsPort transactionDetailsPort
    ) {
        this.transactionDetailsPort = transactionDetailsPort;
    }

    public void execute(
        InputStream stream
    ) throws IOException {


        CsvSchema schema = mapper.schemaFor(TransactionDetails.class).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(TransactionDetails.class).with(schema);
        /**
         * Create an abstraction with an interface defining the contract and providers
         * Should have a provider for serializing data from a CSV file
         * Should have a provider for serializing data from a Json String
         */
        List<TransactionDetails> transactions = reader.<TransactionDetails>readValues(stream).readAll();

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
