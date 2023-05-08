package br.com.luiz_gambalonga.api.services.impl;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.domain.dto.UsuarioDTO;
import br.com.luiz_gambalonga.api.repositories.UsuarioRepository;
import br.com.luiz_gambalonga.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
@SpringBootTest
class UsuarioServiceImplTest {

    public static final Long ID = 1l;
    public static final String NAME = "LUIZ HENRIQUE";
    public static final String EMAIL = "GAMBALONGALUIZHENRIQUE@GMAIL.COM";
    public static final String SENHA = "123";

    @InjectMocks
    private UsuarioServiceImpl service;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private ModelMapper mapper;

    private UsuarioDTO usuarioDTO;
    private Usuario usuarioBanco;
    private Optional<Usuario> optionalUsuarioBanco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    @Test
    void whenFindByIdThenRetornAnUserInstance() {
        Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(optionalUsuarioBanco);
        Usuario response = service.findById(ID);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Usuario.class, response.getClass());
        Assertions.assertEquals(ID,response.getId());
    }
    @Test
    void whenFindByIdThenReturnObjectoNotFoundException(){
        Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException("Não localizado o usuario!"));
        try{
            service.findById(ID);
        }catch (Exception e){
            Assertions.assertEquals(ObjectNotFoundException.class,e.getClass());
            Assertions.assertEquals("Não localizado o usuario!", e.getMessage());
        }
    }
    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
    private void startUsuario(){
        usuarioBanco = new Usuario(ID,NAME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID,NAME, EMAIL, SENHA);
        optionalUsuarioBanco = Optional.of(new Usuario(ID,NAME, EMAIL, SENHA));
    }
}