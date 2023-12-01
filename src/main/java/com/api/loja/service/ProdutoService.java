package com.api.loja.service;

import com.api.loja.entity.Produtos;
import com.api.loja.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
   private final  ProdutoRepository produtoRepository;

    public Produtos salvar(Produtos produtos) {
        return produtoRepository.save(produtos);
    }
    @Transactional(readOnly = true)
    public List<Produtos> buscarProdutos() {
        return produtoRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Produtos getProdutoId(Long id) {
        return  produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não localizado")
        );
    }
}
