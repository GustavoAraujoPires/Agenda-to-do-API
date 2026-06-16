package github.gustavoaraujopires.demo.controller.DTO;

import github.gustavoaraujopires.demo.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta ( int status, String mensagem, List<ErroCampo> erros) {

    public static ErroResposta idInvalido(String mensagem){
        return new ErroResposta(HttpStatus.NOT_FOUND.value(),mensagem, List.of());
    }
        public static ErroResposta usuarionaoEncontrado(String mensagem){
        return new ErroResposta(HttpStatus.FORBIDDEN.value(),mensagem, List.of());
    }

    public static ErroResposta StatusInvalido(String mensagem){
        return new ErroResposta(HttpStatus.CONFLICT.value(),mensagem, List.of());
    }
}
