package com.api.loja.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produtos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "preco")
    private BigDecimal price;
    /*
     @Lob indica que o campo imagem será armazenado como um LOB (Large Object) no banco de dados.
     A anotação @Column(columnDefinition = "BLOB") fornece uma dica sobre o tipo de coluna a ser usado.
     */
    @Lob
    @Column(name = "imagem", columnDefinition = "BLOB")
    private byte[] imagem;
}
