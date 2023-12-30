package com.api.ecommerce.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class ProdutoDTO {

    private String produto;

    private String tipo;

    private BigDecimal valor;

}
