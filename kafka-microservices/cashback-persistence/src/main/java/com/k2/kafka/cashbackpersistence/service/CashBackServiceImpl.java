package com.k2.kafka.cashbackpersistence.service;

import com.k2.kafka.cashbackpersistence.domain.CashBack;
import com.k2.kafka.cashbackpersistence.repository.CashBackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CashBackServiceImpl implements CashBackService {

    private final CashBackRepository cashBackRepository;

    public CashBackServiceImpl(CashBackRepository cashBackRepository) {
        this.cashBackRepository = cashBackRepository;
    }

    @Override
    public CashBack save(CashBack entity) {

        return cashBackRepository.save(entity);
    }

    @Override
    public Page<CashBack> listCash( Pageable pageable) {
        return cashBackRepository.findAll(pageable);
    }
}
