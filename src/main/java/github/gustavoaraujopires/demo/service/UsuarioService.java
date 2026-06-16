package github.gustavoaraujopires.demo.service;

import github.gustavoaraujopires.demo.exception.IdNaoEncontradoException;
import github.gustavoaraujopires.demo.model.Usuario;
import github.gustavoaraujopires.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public void salvar(Usuario usuario){
        var senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        repository.save(usuario);
    }

    public Usuario buscarPorLogin(String login){

        return repository.findByLogin(login);
    }

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }

    public void deletar (Long id){
        repository.deleteById(id);
    }
}
