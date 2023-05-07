package br.com.luiz_gambalonga.api.services;

import br.com.luiz_gambalonga.api.domain.Usuario;

public interface UsuarioService {

    Usuario findById(Long id);
}
