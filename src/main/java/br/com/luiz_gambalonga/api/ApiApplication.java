package br.com.luiz_gambalonga.api;

import br.com.luiz_gambalonga.api.domain.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Usuario usuario1 = new Usuario(1L,"LUIZ GAMBALONGA", "gamblonga@gmail.com","123");

		System.out.println(usuario1);
	}

}
