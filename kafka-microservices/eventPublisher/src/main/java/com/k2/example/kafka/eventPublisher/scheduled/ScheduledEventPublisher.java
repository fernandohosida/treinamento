package com.k2.example.kafka.eventPublisher.scheduled;

import com.k2.example.kafka.eventPublisher.repository.DebtRepository;
import com.k2.example.kafka.eventPublisher.service.EventPublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledEventPublisher {

    private final DebtRepository debtRepository;
    private final EventPublisherService eventPublisherService;
    private Long counter;

    ScheduledEventPublisher(final DebtRepository debtRepository,final EventPublisherService eventPublisherService) {
        resetCounter();
        this.debtRepository = debtRepository;
        this.eventPublisherService = eventPublisherService;
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void publishEvent() {
        debtRepository.findById(counter).ifPresentOrElse(debt -> {
            counter += 1;
            eventPublisherService.publish(debt);
            log.info("Debt '{}' publised '{}'", debt.getId(), debt.getClient().getName());
        }, () -> resetCounter());
    }

    private void resetCounter() {
        this.counter = 1L;
    }
}
