package com.api.loja.controller;

import com.api.loja.dto.ProdutoDto;
import com.api.loja.entity.Produtos;
import com.api.loja.service.ProdutoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> setProduto(@RequestBody Produtos produtos) {
        Produtos prod = produtoService.salvar(produtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @GetMapping("/allProducts")
    public ResponseEntity <List<ProdutoDto>> getAllProducts() {
        List<ProdutoDto> produtos = produtoService.buscarProdutos().stream().map(ProdutoDto::FromEntity).toList();
        return ResponseEntity.ok().body(produtos);
    }

}
