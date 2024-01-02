package com.k2.example.kafka.eventPublisher.service;

import com.k2.example.kafka.eventPublisher.domain.Debt;
import com.k2.example.kafka.eventPublisher.exception.DebtPublishException;

public interface EventPublisherService {

    void publish(Debt debt) throws DebtPublishException;

}
