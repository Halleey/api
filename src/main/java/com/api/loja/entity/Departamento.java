package com.api.loja.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "Departamento")
@Getter
@Setter
@RequiredArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "setor")
    private String name;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;
}