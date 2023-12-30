package com.api.ecommerce.entity;

import com.api.ecommerce.service.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "EC_PRODUTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Produto {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "CREATED_AT")
    private Instant createdAt;

}
