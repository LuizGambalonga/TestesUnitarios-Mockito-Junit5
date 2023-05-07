package br.com.luiz_gambalonga.api.services.impl;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.repositories.UsuarioRepository;
import br.com.luiz_gambalonga.api.services.UsuarioService;
import br.com.luiz_gambalonga.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não localizado o usuario!"));
    }
}
