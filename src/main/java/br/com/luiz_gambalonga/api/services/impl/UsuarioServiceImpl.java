package br.com.luiz_gambalonga.api.services.impl;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.domain.dto.UsuarioDTO;
import br.com.luiz_gambalonga.api.repositories.UsuarioRepository;
import br.com.luiz_gambalonga.api.services.UsuarioService;
import br.com.luiz_gambalonga.api.services.exceptions.DataIntegrateViolationException;
import br.com.luiz_gambalonga.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não localizado o usuario!"));
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario create(UsuarioDTO usuarioDTO) {
        findByEmail(usuarioDTO);
        return usuarioRepository.save(mapper.map(usuarioDTO,Usuario.class));
    }
    private void findByEmail(UsuarioDTO obj){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(obj.getEmail());
        if(usuario.isPresent()){
            throw new DataIntegrateViolationException("Já existe um Email cadastrado com este nome");
        }
    }
}
