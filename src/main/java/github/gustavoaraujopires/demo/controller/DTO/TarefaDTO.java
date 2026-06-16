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
        private String titulo;

        @NotBlank(message = "Descricão, Obrigatorio")
        private String descricao;

        private StatusTarefa status;

        @NotNull(message = "Data, Obrigatorio")
        private LocalDate dataInicio;

        @NotNull(message = "Data, Obrigatorio")
        private LocalDate dataLimite;

}
