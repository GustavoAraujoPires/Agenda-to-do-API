package github.gustavoaraujopires.demo.controller.DTO;


import github.gustavoaraujopires.demo.model.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TarefaDTO {

        @NotBlank(message = "Titulo, Obrigatorio")
        @Size(max = 200, min = 10, message = "Titulo fora de padrão")
        private String titulo;

        @NotBlank(message = "Descricão, Obrigatorio")
        @Size(max = 500, min = 10, message = "Descrição fora de padrão")
        private String descricao;

        @Size(max = 20)
        private StatusTarefa status;

        @NotNull(message = "Data, Obrigatorio")
        private LocalDate dataInicio;

        @NotNull(message = "Data, Obrigatorio")
        private LocalDate dataLimite;

}
