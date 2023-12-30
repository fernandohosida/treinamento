package com.api.ecommerce.service;

import com.api.ecommerce.entity.Produto;
import com.api.ecommerce.repository.ProdutoRepository;
import com.api.ecommerce.service.dto.ProdutoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProdutoServiceTest {

    private static final String PRODUTO = "TECLADO";

    private static final String TIPO = "PERIFERICO";

    private static final BigDecimal VALOR = BigDecimal.TEN;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoRepository repository;

    @Test
    public void produtoSaveTest() {
        Produto produto = produtoService.save(getProdutoDTO());

        assertThat(produto.getDescricao()).isEqualTo(PRODUTO);
        assertThat(produto.getTipo()).isEqualTo(TIPO);
        assertThat(produto.getValor()).isEqualByComparingTo(VALOR);
        assertThat(produto.getId()).isNotNull();
        assertThat(produto.getCreatedAt()).isNotNull();

        Optional<Produto> produtoOptional = repository.findById(produto.getId());

        assertThat(produtoOptional).isPresent();

    }

    private ProdutoDTO getProdutoDTO() {
        return ProdutoDTO.builder().produto(PRODUTO).tipo(TIPO).valor(VALOR).build();
    }

    @Test
    public void findById() {
    }
}