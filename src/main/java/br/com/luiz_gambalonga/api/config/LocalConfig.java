package br.com.luiz_gambalonga.api.config;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public void startDB(){
        Usuario usuario1 = new Usuario(null,"LUIZ","GAMBALONGALUIZHENRIQUE@GMAIL.COM","123");
        Usuario usuario2 = new Usuario(null,"LUIZ2","GAMBALONGALUIZHENRIQUE@GMAIL.COM2","1234");
        usuarioRepository.saveAll(List.of(usuario1,usuario2));
    }
}
