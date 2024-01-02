package com.k2.kafka.cashbackpersistence.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "cashback")
public class CashBack {

    @Id
    @Column(name = "pay_code")
    private String payCode;

    private String title;

    @Column(name = "client_id")
    private Long clientId;

}
