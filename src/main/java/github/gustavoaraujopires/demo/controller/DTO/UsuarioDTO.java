package github.gustavoaraujopires.demo.controller.DTO;

import java.util.List;

public record UsuarioDTO(String login, String senha, List<String> roles) {
}
