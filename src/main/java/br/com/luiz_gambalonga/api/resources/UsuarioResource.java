package br.com.luiz_gambalonga.api.resources;

import br.com.luiz_gambalonga.api.domain.dto.UsuarioDTO;
import br.com.luiz_gambalonga.api.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findByIdUsuario(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(usuarioService.findById(id), UsuarioDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<UsuarioDTO> usuarioDTO = usuarioService.findAll().stream().map(x -> mapper.map(x,UsuarioDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuarioDTO);
    }
}
