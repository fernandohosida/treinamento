package com.api.ecommerce.service;

import com.api.ecommerce.entity.Produto;
import com.api.ecommerce.repository.ProdutoRepository;
import com.api.ecommerce.service.dto.ProdutoDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(ProdutoDTO requestDto) {
        return produtoRepository.saveAndFlush(getProduto(requestDto));
    }

    @NotNull
    private Produto getProduto(ProdutoDTO requestDto) {
        return new Produto(UUID.randomUUID(),
                requestDto.getProduto(),
                requestDto.getTipo(),
                requestDto.getValor(),
                Instant.now());
    }

    public Produto findById(UUID id) throws RuntimeException {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return produto;
    }
}
