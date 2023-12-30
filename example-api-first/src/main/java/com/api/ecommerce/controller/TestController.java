package com.api.ecommerce.controller;


import com.api.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class TestController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/getcount")
    public @ResponseBody ResponseEntity<String> getCount() {
        Long quantidade = produtoRepository.findCountByTipo("PERIFERICO");

        return new ResponseEntity<String>("GET Response: " + quantidade.toString() , HttpStatus.OK);
    }

    @GetMapping("/getsum")
    public @ResponseBody ResponseEntity<String> getSum() {
        BigDecimal valor = produtoRepository.findSumByTipo("PERIFERICO");

        return new ResponseEntity<String>("GET Response: " + valor.toString() , HttpStatus.OK);
    }

}
