package github.gustavoaraujopires.demo.security;

import github.gustavoaraujopires.demo.model.Usuario;
import github.gustavoaraujopires.demo.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoginSocialSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UsuarioService service;
    private final static String SENHA_PADRAO = "12345667";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();

        String email = oAuth2User.getAttribute("email");

        Usuario usuario = service.buscarPorEmail(email);

        if (usuario == null) {
            usuario = cadastrarUsuarioNaBase(email);
        }

        authentication = new CustomAuthentication(usuario);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        response.sendRedirect("/home");
    }

    private Usuario cadastrarUsuarioNaBase(String email) {
        Usuario usuario;
        usuario = new Usuario();
        usuario.setEmail(email);

        usuario.setLogin(tratarLoginApartirDoEmail(email));

        usuario.setSenha(SENHA_PADRAO);
        usuario.setRoles(List.of("USUARIOS"));
        service.salvar(usuario);
        return usuario;
    }

    private String tratarLoginApartirDoEmail(String email) {
        return email.substring(0,email.indexOf("@"));
    }
}
