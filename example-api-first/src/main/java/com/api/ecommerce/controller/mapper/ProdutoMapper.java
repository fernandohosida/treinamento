package com.api.ecommerce.controller.mapper;

import com.api.ecommerce.entity.Produto;
import com.api.ecommerce.generated.model.ProdutoRequestDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProdutoMapper {

    Produto toProduto(ProdutoRequestDTO dto);

}
