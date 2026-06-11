package github.gustavoaraujopires.demo.controller.DTO;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta ( int status, String mensagem, List<ErroCampo> erros) {

    public static ErroResposta idInvalido(String mensagem){
        return new ErroResposta(HttpStatus.NOT_FOUND.value(),mensagem, List.of());
    }
}
