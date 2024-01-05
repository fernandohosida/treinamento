package com.k2.kafka.cashbackpersistence.service;

import com.k2.kafka.cashbackpersistence.domain.CashBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CashBackService {

    public CashBack save(CashBack cashBack);

    public Page<CashBack> listCash( Pageable pageable);
}
