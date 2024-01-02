package com.k2.example.kafka.eventPublisher.repository;

import com.k2.example.kafka.eventPublisher.domain.Debt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DebtRepository extends CrudRepository<Debt, Long>, PagingAndSortingRepository<Debt, Long> {

}
