package com.api.loja.controller;

import com.api.loja.dto.UsuarioCreateDto;
import com.api.loja.entity.Usuario;
import com.api.loja.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Usuario> updatePassword (@PathVariable Long id, @RequestBody Usuario usuario) {

        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok().body(user);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll () {
        List<Usuario> users = usuarioService.buscarPorTodos();
        return ResponseEntity.ok().body(users);
    }

}