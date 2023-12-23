package com.api.loja.service;

import com.api.loja.entity.Produtos;
import com.api.loja.exceptions.IdException;
import com.api.loja.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
                () -> new IdException(id)
        );
    }
    @Transactional
    public Produtos salvarComImagem(Produtos produtos, MultipartFile imagem) {
        try {
            produtos.setImagem(imagem.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao converter a imagem para bytes: " + e.getMessage());
        }
        return produtoRepository.save(produtos);
    }
}
