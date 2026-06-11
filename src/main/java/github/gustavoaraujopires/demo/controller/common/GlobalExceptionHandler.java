package github.gustavoaraujopires.demo.controller.common;

import github.gustavoaraujopires.demo.controller.DTO.ErroResposta;
import github.gustavoaraujopires.demo.exception.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta IdNaoEncontradoExceptionHenler(IdNaoEncontradoException e){
        return ErroResposta.idInvalido(e.getLocalizedMessage());
    }
}
