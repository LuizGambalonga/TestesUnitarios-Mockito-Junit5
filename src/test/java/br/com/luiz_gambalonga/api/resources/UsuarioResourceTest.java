package br.com.luiz_gambalonga.api.resources;

import br.com.luiz_gambalonga.api.domain.Usuario;
import br.com.luiz_gambalonga.api.domain.dto.UsuarioDTO;
import br.com.luiz_gambalonga.api.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

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
    private UsuarioServiceImpl service;
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
    void findByIdThenReturnSuccess() {
        Mockito.when(service.findById(Mockito.anyLong())).thenReturn(usuarioBanco);
        Mockito.when(mapper.map(Mockito.any(),Mockito.any())).thenReturn(usuarioDTO);
        ResponseEntity<UsuarioDTO> response = resource.findByIdUsuario(ID);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(ResponseEntity.class,response.getClass());
        Assertions.assertEquals(UsuarioDTO.class,response.getBody().getClass());

        Assertions.assertEquals(ID,response.getBody().getId());
        Assertions.assertEquals(EMAIL,response.getBody().getEmail());
        Assertions.assertEquals(NAME,response.getBody().getNome());
        Assertions.assertEquals(SENHA,response.getBody().getSenha());
    }

    @Test
    void whenFindAllReturnAListOfUsuarioDTO() {
        Mockito.when(service.findAll()).thenReturn(List.of(usuarioBanco));
        Mockito.when(mapper.map(Mockito.any(),Mockito.any())).thenReturn(usuarioDTO);

        ResponseEntity<List<UsuarioDTO>> response = resource.findAll();
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class,response.getClass());
        Assertions.assertEquals(ArrayList.class,response.getBody().getClass());
        Assertions.assertEquals(UsuarioDTO.class, response.getBody().get(0).getClass());

        Assertions.assertEquals(ID,response.getBody().get(0).getId());
    }

    @Test
    void whenCreateThenReturnCreated() {
        Mockito.when(service.create(Mockito.any())).thenReturn(usuarioBanco);
        ResponseEntity<UsuarioDTO> response = resource.create(usuarioDTO);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void whenUpdateReturnSuccess() {
        Mockito.when(service.update(usuarioDTO)).thenReturn(usuarioBanco);
        Mockito.when(mapper.map(Mockito.any(),Mockito.any())).thenReturn(usuarioDTO);
        ResponseEntity<UsuarioDTO> response = resource.update(ID,usuarioDTO);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(ResponseEntity.class,response.getClass());
        Assertions.assertEquals(UsuarioDTO.class,response.getBody().getClass());

        Assertions.assertEquals(ID,response.getBody().getId());
    }


    private void startUsuario(){
        usuarioBanco = new Usuario(ID,NAME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID,NAME, EMAIL, SENHA);

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(attributes);
    }
}