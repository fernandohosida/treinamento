package com.api.ecommerce.controller;

import com.api.ecommerce.controller.mapper.ProdutoMapper;
import com.api.ecommerce.entity.Produto;
import com.api.ecommerce.generated.model.ProdutoRequestDTO;
import com.api.ecommerce.generated.model.ProdutoResponseDTO;
import com.api.ecommerce.generated.web.ProdutoApiDelegate;
import com.api.ecommerce.service.ProdutoService;
import com.api.ecommerce.service.dto.ProdutoDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ProdutoApiDelegateImpl implements ProdutoApiDelegate {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ResponseEntity<ProdutoResponseDTO> getProduto(UUID id) {
        return ResponseEntity.ok().body(getProdutoResponseDTO(produtoService.findById(id)));
    }

    @Override
    public ResponseEntity<ProdutoResponseDTO> saveProduto(ProdutoRequestDTO produtoRequestDTO) {

        ProdutoDTO requestDto = ProdutoDTO.builder()
                .produto(produtoRequestDTO.getProduto())
                .valor(produtoRequestDTO.getValor())
                .tipo(produtoRequestDTO.getTipo()).build();

        return ResponseEntity.ok().body(getProdutoResponseDTO(produtoService.save(requestDto)));
    }

    private ProdutoResponseDTO getProdutoResponseDTO(Produto produto) {
        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .produto(produto.getDescricao())
                .tipo(produto.getTipo())
                .valor(produto.getValor())
                .build();
    }
}
