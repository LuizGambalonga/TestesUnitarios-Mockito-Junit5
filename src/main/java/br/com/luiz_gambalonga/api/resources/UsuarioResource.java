package br.com.luiz_gambalonga.api.resources;

import br.com.luiz_gambalonga.api.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/usuario")
public class UsuarioResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findByIdUsuario(@PathVariable Long id){
        return ResponseEntity.ok().body(new Usuario(1L,"zezinhodafeira","zezote@gmail.com","123"));
    }
}
