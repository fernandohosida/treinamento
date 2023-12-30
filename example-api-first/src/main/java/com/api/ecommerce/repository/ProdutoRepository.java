package com.api.ecommerce.repository;

import com.api.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    @Query("SELECT count(*) FROM Produto u WHERE u.tipo = :tipo")
    Long findCountByTipo(@Param("tipo") String tipo);


    @Query("SELECT SUM(u.valor) FROM Produto u WHERE u.tipo = :tipo")
    BigDecimal findSumByTipo(@Param("tipo") String tipo);
}
