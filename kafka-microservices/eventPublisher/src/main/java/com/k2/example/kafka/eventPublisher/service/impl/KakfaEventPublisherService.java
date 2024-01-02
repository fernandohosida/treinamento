package com.k2.example.kafka.eventPublisher.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2.example.kafka.eventPublisher.config.KafkaConfigProps;
import com.k2.example.kafka.eventPublisher.domain.Debt;
import com.k2.example.kafka.eventPublisher.exception.DebtPublishException;
import com.k2.example.kafka.eventPublisher.service.EventPublisherService;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class KakfaEventPublisherService implements EventPublisherService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    public KakfaEventPublisherService(ObjectMapper objectMapper, final KafkaTemplate<String, String> kafkaTemplate, final KafkaConfigProps kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    @Override
    public void publish(Debt debt) {
        try {
            final String payload = objectMapper.writeValueAsString(debt);
            kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);

        } catch (final JsonProcessingException ex) {
            throw new DebtPublishException("Unable to publish debt", ex);
        }
    }
}
