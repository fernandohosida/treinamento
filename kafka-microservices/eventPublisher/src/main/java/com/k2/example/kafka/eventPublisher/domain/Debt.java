package com.k2.example.kafka.eventPublisher.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "debt_table")
public class Debt {

    @Id
    private Long id;

    private String pay_code;

    private String title;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
