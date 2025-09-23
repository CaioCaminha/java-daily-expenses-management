package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.transaction;

import com.caiocaminha.javadailyexpenses.core.domain.entities.TransactionDetails;
import com.caiocaminha.javadailyexpenses.core.usecase.CreateTransactionUseCase;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePartEvent;
import org.springframework.http.codec.multipart.FormPartEvent;
import org.springframework.http.codec.multipart.PartEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Component
public class TransactionHandler {

    private CreateTransactionUseCase createTransactionUseCase;

    public TransactionHandler(CreateTransactionUseCase createTransactionUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
    }

//    @Async //response type must be wrapped in a Future
    public Mono<ServerResponse> createTransaction(ServerRequest request) {
        var body = request.bodyToMono(TransactionDetails.class).blockOptional();

        body.ifPresent(transactionDetails -> {

        });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("123");
    }

    /**
     *concateMap: Used when each transformation returns another Reactive Stream ( in this case a Flux)
     *  Subscribes to each element in order, ensuring that element 1 is emitted before element 2 starts, ensuring sequential subscription
     *  Useful when it's important to guarantee the order (Alternative Option for flatMap when order is important)
     *  but if you want to process in parallel and mantain the order can use flatMapSequencial, subscribes in parallel but buffer reorders when emitting
     *
     *switchOnFirst: Lets you inspect the first signal (Usually the first element emmited by the source Flux)
     *  before deciding how you are going to consume the rest of the Flux. It's very useful when the way you
     *  process a stream depends on what the first element is. In this case it's useful because we need to decide
     *  if it's an instance of FormPartEvent or FilePartEvent, this checking will decide how we are going to consume
     *  all the remaining elements on the Flux
     *
     */
    public Mono<ServerResponse> createFromMultipart(ServerRequest request) {

        Flux<PartEvent> allPartEvents = request.bodyToFlux(PartEvent.class);
        allPartEvents.windowUntil(PartEvent::isLast)
                .concatMap(part -> part.switchOnFirst((signal, partEvents) -> {
                    if(signal.hasValue()) {
                        PartEvent event = signal.get();
                        if(event instanceof FormPartEvent formEvent) {
                            String value = formEvent.value();
                            // todo: handle formEvent value
                            return null;
                        }
                        else if(event instanceof FilePartEvent fileEvent) {
                            String fileName = fileEvent.filename();
                            Flux<DataBuffer> contents = partEvents.map(PartEvent::content);
                            // todo: handle file upload
                            return null;
                        }
                        else {
                            return Mono.error(new RuntimeException("Error processing event: " + event));
                        }
                    }
                    else {
                        return partEvents;
                    }
                }));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("123");
    }

}
