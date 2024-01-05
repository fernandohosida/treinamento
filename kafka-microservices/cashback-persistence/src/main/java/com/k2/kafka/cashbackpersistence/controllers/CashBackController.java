package com.k2.kafka.cashbackpersistence.controllers;

import com.k2.kafka.cashbackpersistence.domain.CashBack;
import com.k2.kafka.cashbackpersistence.service.CashBackService;
import com.k2.kafka.cashbackpersistence.service.CashBackServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashBackController {

    private final CashBackService cashBackService;

    public CashBackController(CashBackService cashBackService) {
        this.cashBackService = cashBackService;
    }

    @GetMapping(path = "/cashback")
    public Page<CashBack> listCashBack(final Pageable pageable) {
        return cashBackService.listCash(pageable);
    }

}
