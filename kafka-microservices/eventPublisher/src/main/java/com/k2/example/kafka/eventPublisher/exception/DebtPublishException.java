package com.k2.example.kafka.eventPublisher.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.k2.example.kafka.eventPublisher.domain.Debt;

public class DebtPublishException extends RuntimeException {

    public DebtPublishException(String unableToPublishBook, JsonProcessingException ex) {
        super(unableToPublishBook, ex);
    }
}
