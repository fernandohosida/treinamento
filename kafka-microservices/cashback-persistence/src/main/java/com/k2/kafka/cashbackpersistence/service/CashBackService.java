package com.k2.kafka.cashbackpersistence.service;

import com.k2.kafka.cashbackpersistence.domain.CashBack;
import com.k2.kafka.cashbackpersistence.repository.CashBackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CashBackService {

    private final CashBackRepository cashBackRepository;

    public CashBackService(CashBackRepository cashBackRepository) {
        this.cashBackRepository = cashBackRepository;
    }

    public CashBack save(CashBack entity) {

        return cashBackRepository.save(entity);
    }

    public Page<CashBack> listCash( Pageable pageable) {
        return cashBackRepository.findAll(pageable);
    }
}
