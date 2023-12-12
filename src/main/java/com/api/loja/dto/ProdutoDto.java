package com.api.loja.dto;
import com.api.loja.entity.Produtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private byte[] imagem;

    public ProdutoDto(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProdutoDto FromEntity(Produtos produtos) {
        return new ProdutoDto(
                produtos.getId(),
                produtos.getName(),
                produtos.getPrice(),
                produtos.getImagem()
        );
    }

    public Produtos toEntity() {
        Produtos produtos = new Produtos();
        produtos.setId(this.id);
        produtos.setName(this.name);
        produtos.setPrice(this.price);
        produtos.setImagem(this.imagem);
        return produtos;
    }
}