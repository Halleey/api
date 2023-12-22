package com.api.loja.service;
import com.api.loja.entity.CarroCompras;
import com.api.loja.entity.Usuario;
import com.api.loja.repository.CarrinhoRepository;
import com.api.loja.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CarrinhoRepository carrinhoRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        CarroCompras carrinho = new CarroCompras();
        carrinhoRepository.save(carrinho);
        usuario.setCarrinho(carrinho);

        return usuarioRepository.save(usuario);
    }
    @Transactional(readOnly  = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }
    @Transactional
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> buscarPorTodos() {
        return usuarioRepository.findAll();
    }
}