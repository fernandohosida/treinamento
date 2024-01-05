package com.k2.kafka.cashbackpersistence.listerners;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2.kafka.cashbackpersistence.domain.CashBack;
import com.k2.kafka.cashbackpersistence.domain.Notification;
import com.k2.kafka.cashbackpersistence.exceptions.InvalidMessageException;
import com.k2.kafka.cashbackpersistence.service.CashBackService;
import com.k2.kafka.cashbackpersistence.service.CashBackServiceImpl;
import com.k2.kafka.cashbackpersistence.service.NotificationService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("production")
public class DebtListener {

    private final ObjectMapper objectMapper;

    private final CashBackService cashBackService;

    private final NotificationService notificationService;

    public DebtListener(ObjectMapper objectMapper, CashBackService cashBackService, NotificationService notificationService) {
        this.objectMapper = objectMapper;
        this.cashBackService = cashBackService;
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "debt.published")
    public String listener(final String in) {
        log.info(in);
        final Map<String, Object> payload = readJsonAsMap(in);
        final CashBack cashback = cashBackFromPayload(payload);
        final CashBack savedCashBack = cashBackService.save(cashback);
        final String message = String.format(
            "CashB '%s' [%s] persisted!",
            savedCashBack.getTitle(),
            savedCashBack.getPayCode()
        );
        notificationService.publishNotification(
            Notification.builder()
                .message(message)
                .timestamp(LocalDateTime.now())
                .service("cash-persistence")
                .build());

        return in;
    }


    private Map<String, Object> readJsonAsMap(final String json) {
        try {
            final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            return objectMapper.readValue(json, typeRef);
        } catch (JsonProcessingException ex) {
            throw new InvalidMessageException();
        }
    }

    private CashBack cashBackFromPayload(final Map<String, Object> payload) {
        final Integer clientId = (Integer) ((HashMap<String, Object>) payload.get("client")).get("id");

        return CashBack.builder().title(payload.get("title").toString())
            .payCode(payload.get("pay_code").toString()).clientId(clientId.longValue()).build();
    }

}
