package com.api.loja.dto;

import com.api.loja.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String name;
    private String email;
    private String endereco;


    public static UsuarioDto fromEntity(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getEndereco()
        );
    }

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setName(this.name);
        usuario.setEmail(this.email);
        usuario.setEndereco(this.endereco);
        return usuario;
    }
}
