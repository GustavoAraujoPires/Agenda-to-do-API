package github.gustavoaraujopires.demo.controller.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UsuarioDTO(
        @NotBlank(message = "Login Inválido")
        String login,
        @NotBlank(message = "Senha Inválida")
        String senha,
        @Email(message = "Email inválido")
        @NotBlank(message = "campo obrigatorio")
        String email,
        List<String> roles) {
}
