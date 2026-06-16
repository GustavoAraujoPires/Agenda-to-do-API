package github.gustavoaraujopires.demo.controller.common;

import github.gustavoaraujopires.demo.controller.DTO.ErroResposta;
import github.gustavoaraujopires.demo.exception.IdNaoEncontradoException;
import github.gustavoaraujopires.demo.exception.StatusInvalidoException;
import github.gustavoaraujopires.demo.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta IdNaoEncontradoExceptionHandler(IdNaoEncontradoException e){
        return ErroResposta.idInvalido(e.getMessage());
    }

    @ExceptionHandler(StatusInvalidoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta StatusNaoEncontradoExceptionHandler(StatusInvalidoException e){
        return ErroResposta.StatusInvalido(e.getMessage());
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErroResposta UsuarionaoEncontradoExceptionHandler(UsuarioNaoEncontradoException e){
        return ErroResposta.usuarionaoEncontrado(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResposta ErroNaoTratadoExceptionHandler(RuntimeException e){
        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro inesperado. Estamos trabalhando para resolver o mais rápido possível, Obrigado.", List.of());
    }
}
