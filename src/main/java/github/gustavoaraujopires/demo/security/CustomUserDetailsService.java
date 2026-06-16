package github.gustavoaraujopires.demo.security;

import github.gustavoaraujopires.demo.exception.UsuarioNaoEncontradoException;
import github.gustavoaraujopires.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsuarioNaoEncontradoException {
        var usuario = service.buscarPorLogin(login);
        if (usuario == null){
             new UsuarioNaoEncontradoException("Usuario não encontrado");
        }

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getRoles().toArray(new String[usuario.getRoles().size()]))
                .build();
    }
}
