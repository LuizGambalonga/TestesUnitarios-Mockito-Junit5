package br.com.luiz_gambalonga.api.resources;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.domain.dto.UsuarioDTO;
import br.com.luiz_gambalonga.api.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

class UsuarioResourceTest {

    public static final Long ID = 1l;
    public static final String NAME = "LUIZ HENRIQUE";
    public static final String EMAIL = "GAMBALONGALUIZHENRIQUE@GMAIL.COM";
    public static final String SENHA = "123";
    public static final String JA_EXISTE_UM_EMAIL_CADASTRADO_COM_ESTE_NOME = "Já existe um Email cadastrado com este nome";


    @InjectMocks
    private UsuarioResource resource;
    //esta anotação @Mock seria para dizer que serão instancias ficticias e não reais.
    @Mock
    private UsuarioServiceImpl UsuarioServiceImpl;
    @Mock
    private ModelMapper mapper;

    private UsuarioDTO usuarioDTO;
    private Usuario usuarioBanco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    @Test
    void findByIdUsuario() {
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
    void testUpdate() {
    }

    private void startUsuario(){
        usuarioBanco = new Usuario(ID,NAME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID,NAME, EMAIL, SENHA);
    }
}