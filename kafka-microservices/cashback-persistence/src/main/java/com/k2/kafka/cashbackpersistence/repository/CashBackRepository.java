package com.k2.kafka.cashbackpersistence.repository;

import com.k2.kafka.cashbackpersistence.domain.CashBack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CashBackRepository extends CrudRepository<CashBack, String>, PagingAndSortingRepository<CashBack, String> {

}
