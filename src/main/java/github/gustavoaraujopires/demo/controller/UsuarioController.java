package github.gustavoaraujopires.demo.controller;

import github.gustavoaraujopires.demo.controller.DTO.UsuarioDTO;
import github.gustavoaraujopires.demo.controller.mappers.UsuarioMapper;
import github.gustavoaraujopires.demo.model.Usuario;
import github.gustavoaraujopires.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar (@RequestBody UsuarioDTO dto){
        var cliente = mapper.toDTO(dto);
         service.salvar(cliente);
    }

    @GetMapping("{login}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario buscarPorLogin (@PathVariable String login){
        return service.buscarPorLogin(login);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Usuario> buscarTodosUsuarios(){
        return service.buscarTodos();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar (@PathVariable Long id){
        service.deletar(id);
    }

}
