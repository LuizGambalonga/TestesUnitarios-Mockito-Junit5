package br.com.luiz_gambalonga.api.services;

import br.com.luiz_gambalonga.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Long id);
    List<Usuario> findAll();
}
