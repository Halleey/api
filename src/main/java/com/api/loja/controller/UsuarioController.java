package com.api.loja.controller;


import com.api.loja.dto.UsuarioDto;
import com.api.loja.entity.Usuario;
import com.api.loja.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario ) {
        // Criar uma instância de Usuario e definir os valores dos campos
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById (@PathVariable Long id) {

        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(user);

    }
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDto> updatePassword(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioDto.toEntity(); // Converte DTO para Entidade
        Usuario updatedUser = usuarioService.editarSenha(id, usuario.getPassword());
        UsuarioDto updatedUserDto = UsuarioDto.fromEntity(updatedUser); // Converte Entidade para DTO
        return ResponseEntity.ok().body(updatedUserDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDto>> getAll () {
        List<UsuarioDto> users = usuarioService.buscarPorTodos().stream().map(UsuarioDto::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(users);
    }

}