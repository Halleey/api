package com.api.loja.dto;
import com.api.loja.entity.Produtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Long id;
    private String name;
    private Double price;

    public  static ProdutoDto FromEntity(Produtos produtos) {
        return  new ProdutoDto(
                produtos.getId(),
                produtos.getName(),
                produtos.getPrice()
        );
    }
    public Produtos toEntity() {
        Produtos produtos = new Produtos();
        produtos.setId(this.id);
        produtos.setName(this.name);
        produtos.setPrice(this.price);
        return produtos;
    }
}
